package in.ushatech.reviewservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("in.ushatech")
public class ReviewServiceApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(ReviewServiceApplication.class, args);
    }

}
