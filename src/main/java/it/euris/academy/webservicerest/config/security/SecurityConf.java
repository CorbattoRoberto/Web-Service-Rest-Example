package it.euris.academy.webservicerest.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConf {

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

    http
        .authorizeHttpRequests((authorize) ->
            authorize
                .requestMatchers(HttpMethod.GET,"/").permitAll()
                .anyRequest().authenticated()
        )
        .httpBasic(withDefaults());

    return http.build();
  }

}
