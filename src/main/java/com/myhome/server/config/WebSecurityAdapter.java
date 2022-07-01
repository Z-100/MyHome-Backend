//package com.myhome.server.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//public class WebSecurityAdapter extends WebSecurityConfigurerAdapter {
//
//	@Autowired
//	private MyBasicAuthenticationEntryPoint authenticationEntryPoint;
//
//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication()
//				.withUser("user1").password(passwordEncoder().encode("user1Pass"))
//				.authorities("ROLE_USER");
//	}
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests()
//				.antMatchers("/securityNone").permitAll()
//				.anyRequest().authenticated()
//				.and()
//				.httpBasic()
//				.authenticationEntryPoint(authenticationEntryPoint);
//
//		http.addFilterAfter(new CustomFilter(),
//				BasicAuthenticationFilter.class);
//	}
//
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//}