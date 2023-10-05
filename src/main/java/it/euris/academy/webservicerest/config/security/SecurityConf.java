package it.euris.academy.webservicerest.config.security;

import it.euris.academy.webservicerest.data.enums.UserRole;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConf {

  private final WhiteListConfiguration whiteList;

  public SecurityConf(WhiteListConfiguration whiteList) {
    this.whiteList = whiteList;
  }

  @Bean
  public static PasswordEncoder passwordEncoder(){
    return new BCryptPasswordEncoder();
  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

    http
        .csrf(AbstractHttpConfigurer::disable)
        .authorizeHttpRequests((authorize) -> authorize
            .requestMatchers(whiteList.getUrls()).permitAll()
            .requestMatchers(HttpMethod.GET,"/").permitAll()
            .requestMatchers(HttpMethod.GET,"/customers/**").permitAll()
            .requestMatchers("/customers/**").hasRole(UserRole.MANAGER.toString())
            .requestMatchers("/orders/**").hasAnyRole(
                UserRole.MANAGER.toString(),
                UserRole.USER.toString())
            .anyRequest().authenticated()
        )
        .httpBasic(withDefaults());

    return http.build();
  }

  @Bean
  public UserDetailsService userDetailsService(){

    UserDetails user = User.builder()
        .username("user")
        .password(passwordEncoder().encode("user"))
        .roles(UserRole.USER.toString())
        .build();

    UserDetails admin = User.builder()
        .username("academy")
        .password(passwordEncoder().encode("academy"))
        .roles(UserRole.MANAGER.toString())
        .build();

    UserDetails visitor = User.builder()
        .username("visitor")
        .password(passwordEncoder().encode("visitor"))
        .roles(UserRole.VISITOR.toString())
        .build();

    return new InMemoryUserDetailsManager(user, admin, visitor);
  }


}
