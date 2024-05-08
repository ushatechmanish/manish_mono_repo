package in.ushatech.spring_security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig
{
    /**
     * We need to first give authorization for the  uris by creating a bean of SecurityFilterChain
     * The we need to provide UserDetailsManager
     * */
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

    @Bean
    public InMemoryUserDetailsManager getInMemoryUserDetailsManager()
    {
        UserDetails userDetails= User.withUsername("manish")
                .password("simple").authorities("user")
                .build();
        return new InMemoryUserDetailsManager(userDetails);
    }
    
    @SuppressWarnings("deprecation")
    @Bean
    public PasswordEncoder getPasswordEncoder()
    {
        return NoOpPasswordEncoder.getInstance();
    }

}
