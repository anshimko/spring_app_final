package by.htp.shymko.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

import by.htp.shymko.security.AuthProviderImpl;

@Configuration
@EnableWebSecurity
@ComponentScan("by.htp.shymko")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private AuthProviderImpl authProvider;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

//		UserBuilder users = User.withDefaultPasswordEncoder();
//
//		auth.inMemoryAuthentication()
//		.withUser(users.username("andru").password("1234").roles("EMPLOYEE"))
//		.withUser(users.username("mary").password("test123").roles("MANAGER"))
//		.withUser(users.username("susan").password("test123").roles("ADMIN"));
		
		auth.authenticationProvider(authProvider);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/sign_up", "/login").anonymous()
		.antMatchers("/customer/**").authenticated()
		.and().csrf().disable()
		.formLogin()
		.loginPage("/login")
		.loginProcessingUrl("/authenticate")
		.defaultSuccessUrl("/customer/list/1")
		.failureUrl("/login?error=true")
		.and().exceptionHandling()
		.accessDeniedPage("/customer/list/1")
		.and().logout();
	}

}