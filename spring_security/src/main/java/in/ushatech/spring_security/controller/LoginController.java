package in.ushatech.spring_security.controller;

import in.ushatech.spring_security.entity.Customer;
import in.ushatech.spring_security.repository.CustomerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController
{
    private final CustomerRepository customerRepository;

    public LoginController(CustomerRepository customerRepository)
    {
        this.customerRepository = customerRepository;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Customer customer)
    {
        ResponseEntity<String> response = null;
        Customer customer1;
        try
        {
            customer1 = customerRepository.save(customer);
            if (customer1.getId() > 0)
            {
                response = ResponseEntity.status(HttpStatus.CREATED).body("User created successfully");
            }
        } catch (Exception e)
        {
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong at server");
        }
        return response;
    }
}
