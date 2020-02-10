package by.htp.shymko.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import by.htp.shymko.entity.Customer;
import by.htp.shymko.service.CustomerService;

@Component
public class AuthProviderImpl implements AuthenticationProvider{
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String login = authentication.getName();
		Customer customer = customerService.findByLogin(login);
		if(customer == null ) {
			throw new UsernameNotFoundException("User not found");
		}
		
		String password = authentication.getCredentials().toString();
		if(!passwordEncoder.matches(password, customer.getPassword())) {
			throw new BadCredentialsException("Password is incorrect");
		}
		
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
		return new UsernamePasswordAuthenticationToken(customer, null, authorities);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
		
	}

}
