package it.euris.academy.webservicerest.config.security;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "whitelist")
public class WhiteListConfiguration {

  String[] urls;

}
