package in.ushatech.spring_security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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

    // Here Datasource is automatically created from the application.properties entries
//    @Bean
//   public UserDetailsService userDetailsService(DataSource dataSource)
//   {
//       return new JdbcUserDetailsManager(dataSource);
//   }

    @SuppressWarnings("deprecation")
    @Bean
    public PasswordEncoder getPasswordEncoder()
    {
        return NoOpPasswordEncoder.getInstance();
    }

}
