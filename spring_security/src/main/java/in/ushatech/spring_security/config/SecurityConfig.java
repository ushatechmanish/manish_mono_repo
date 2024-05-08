package in.ushatech.spring_security.config;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig
{

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests
                        (
                (authorize) -> authorize.requestMatchers("/myAccount","/myCards","/myBalance","/myLoans").authenticated()
                        .requestMatchers("/notices","/contact").permitAll()
                    ).formLogin(withDefaults())
                .httpBasic(withDefaults());
        return http.build();
    }
}
