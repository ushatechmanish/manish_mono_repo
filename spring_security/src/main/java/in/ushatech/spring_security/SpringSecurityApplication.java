package in.ushatech.spring_security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;


@SpringBootApplication
@EnableJpaRepositories
@EnableWebSecurity
public class SpringSecurityApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(SpringSecurityApplication.class, args);
    }



}
