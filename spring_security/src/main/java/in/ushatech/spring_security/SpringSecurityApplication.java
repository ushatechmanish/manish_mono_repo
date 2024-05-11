package in.ushatech.spring_security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories
public class SpringSecurityApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(SpringSecurityApplication.class, args);
    }


}
