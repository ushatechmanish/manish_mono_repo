package in.ushatech.spring_security.config;

import in.ushatech.spring_security.entity.Customer;
import in.ushatech.spring_security.repository.CustomerRepository;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class CustomUsernamePasswordAuthenticationProvider implements AuthenticationProvider
{
    PasswordEncoder passwordEncoder;
    CustomerRepository customerRepository;

    public CustomUsernamePasswordAuthenticationProvider(PasswordEncoder passwordEncoder, CustomerRepository customerRepository)
    {
        this.passwordEncoder = passwordEncoder;
        this.customerRepository = customerRepository;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException
    {
        String rawPassword = authentication.getCredentials().toString();
        String username = authentication.getName();

        List<Customer> customers = customerRepository.findByEmail(username);

        if (customers == null || customers.isEmpty())
        {
            throw new BadCredentialsException("No customer found with the specified username");
        }

        if (customers.size() > 1)
        {
            throw new BadCredentialsException("Multiple customers found with the same username");
        }

        Customer customer = customers.get(0);
        boolean passwordMatches = passwordEncoder.matches(rawPassword, customer.getPwd());

        if (passwordMatches)
        {
            // Using singletonList for immutable authorities
            List<GrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority(customer.getRole()));
            return new UsernamePasswordAuthenticationToken(username, rawPassword, authorities);
        } else
        {
            throw new BadCredentialsException("Invalid username or password ");
        }
    }


    @Override
    public boolean supports(Class<?> authentication)
    {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));

    }
}
