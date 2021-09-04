package com.mpga.java;

import javax.sql.DataSource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.reactive.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;
	
	//private final UserDetailsService userDetailsService;
	@Bean
	public UserDetailsService userDetailsService() {
//		UserDetails user1 = User
//				.withUsername("namhm")
//				.password("codejava")
//				.roles("USER")
//				.build();
		return new CustomerUserDetailsService();
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());
		
		return authProvider;
		
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
//		String userQuery = "select email as username,password as password,enabled from users where email = ?";
//		String authQuery = "select email as username,user_role as authority from users where email = ?";
//		auth.jdbcAuthentication()
//		.dataSource(dataSource)
//		.rolePrefix("ROLE_")
//		.usersByUsernameQuery(userQuery)
//		.authoritiesByUsernameQuery(authQuery)
//		;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
			.csrf().disable()
			.authorizeRequests()
				.antMatchers("/css/**", "/js/**", "/img/**").permitAll()
				//.antMatchers("/auth/admin/**").hasRole("ADMIN")
				//.antMatchers("/auth/**").hasAnyRole("ADMIN", "USER")
				//.antMatchers("/list_users").hasAnyRole("ADMIN")
				.antMatchers("/list_users").authenticated()//hasRole("ADMIN")
			.anyRequest().permitAll()
			.and()
			.formLogin()
				.usernameParameter("email")
				.passwordParameter("password")
				.permitAll()
				.loginPage("/login")
				.loginProcessingUrl("/login_proc")
				.defaultSuccessUrl("/")
				.permitAll()
			.and()
			.logout()
			.logoutUrl("/logout")
			.logoutSuccessUrl("/")
			.invalidateHttpSession(true)

			.deleteCookies("JSESSIONID")
			.permitAll();
	}
	
}
