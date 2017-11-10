package com.devopsbuddy.config;

import com.devopsbuddy.backend.service.UserSecurityService;
import com.devopsbuddy.web.controllers.ForgotMyPassworldController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.List;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private Environment env;

	@Autowired
	private UserSecurityService userSecurityService;

	/** The encription SALT.*/
	private static final String SALT = "asfsdfhwworjcxcxz";

	@Bean
	public BCryptPasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder(12, new SecureRandom(SALT.getBytes()));
	}


	 /** Public URLs. */
    private static final String[] PUBLIC_MATCHERS = {
            "/webjars/**",
            "/css/**",
            "/js/**",
            "/images/**",
            "/",
            "/about/**",
            "/contact/**",
            "/error/**/*",
            "/console/**",
			 ForgotMyPassworldController.FORGOT_PASSWORD_URL_MAPPING,
			 ForgotMyPassworldController.CHANGE_PASSWORD_PATH
           
    };


	@Override
	protected void configure(HttpSecurity http) throws Exception {

		List<String> activeProfile = Arrays.asList(env.getActiveProfiles());
		if (activeProfile.contains("dev")) {
			http.csrf().disable();
			http.headers().frameOptions().disable();
		}

		http.authorizeRequests().antMatchers(PUBLIC_MATCHERS).permitAll().anyRequest().authenticated().and().formLogin()
				.loginPage("/login").defaultSuccessUrl("/payload").failureUrl("/login?error").permitAll().and().logout()
				.permitAll();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().withUser("user").password("password").roles("USER");
		auth.userDetailsService(userSecurityService)
		.passwordEncoder(passwordEncoder());
	}

}
