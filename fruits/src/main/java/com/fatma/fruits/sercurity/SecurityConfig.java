/*package com.fatma.fruits.sercurity;
import java.util.Arrays;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import jakarta.servlet.http.HttpServletRequest;
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
    {
        http.csrf().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()

                .cors().configurationSource(new CorsConfigurationSource() {
                    @Override
                    public CorsConfiguration getCorsConfiguration(HttpServletRequest
                                                                          request) {
                        CorsConfiguration config = new CorsConfiguration();

                        config.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
                        config.setAllowedMethods(Collections.singletonList("*"));
                        config.setAllowCredentials(true);
                        config.setAllowedHeaders(Collections.singletonList("*"));
                        config.setExposedHeaders(Arrays.asList("Authorization"));
                        config.setMaxAge(3600L);
                        return config;
                    }
                }).and()

                .authorizeHttpRequests().anyRequest().permitAll();
              
        return http.build();

    }


}*/
package com.fatma.fruits.sercurity;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import
org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import jakarta.servlet.http.HttpServletRequest;
@Configuration
@EnableWebSecurity
public class SecurityConfig {
@Bean
 public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
{
http.csrf().disable()
 .sessionManagement()
 .sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
 
 .cors().configurationSource(new CorsConfigurationSource() {
	 @Override
	 public CorsConfiguration getCorsConfiguration(HttpServletRequest
	request) {
	 CorsConfiguration config = new CorsConfiguration();

	config.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
	 config.setAllowedMethods(Collections.singletonList("*"));
	 config.setAllowCredentials(true);
	 config.setAllowedHeaders(Collections.singletonList("*"));
	 config.setExposedHeaders(Arrays.asList("Authorization"));
	 config.setMaxAge(3600L);
	 return config;
	 }
	 }).and()
 
 .authorizeHttpRequests()
// .anyRequest().permitAll();
//consulter tous les Fruits
 //.requestMatchers("/api/all/**").hasAnyAuthority("ADMIN","USER")
//consulter un Fruit par son id
.requestMatchers(HttpMethod.GET,"/api/getbyid/**").hasAnyAuthority("ADMIN","USER")
//ajouter un nouveau Fruit
.requestMatchers(HttpMethod.POST,"/api/addprod/**").hasAnyAuthority("ADMIN")
//modifier un Fruit
.requestMatchers(HttpMethod.PUT,"/api/updateprod/**").hasAuthority("ADMIN")
//supprimer un Fruit
.requestMatchers(HttpMethod.DELETE,"/api/delprod/**").hasAuthority("ADMIN")
.requestMatchers("/Sai/**").hasAnyAuthority("ADMIN","USER")

.anyRequest().authenticated().and()
.addFilterBefore(new JWTAuthorizationFilter(),BasicAuthenticationFilter.class);
return http.build();

}
}