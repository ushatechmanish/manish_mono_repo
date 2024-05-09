package in.ushatech.spring_security.Service;

import in.ushatech.spring_security.entity.Customer;
import in.ushatech.spring_security.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Primary
@Component
public class CustomerUserDetailsManagerService implements UserDetailsService
{
    private static final Logger logger = LoggerFactory.getLogger(CustomerUserDetailsManagerService.class);
    private final CustomerRepository customerRepository;

    public CustomerUserDetailsManagerService(CustomerRepository customerRepository)
    {
        this.customerRepository = customerRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        List<Customer> users = customerRepository.findByEmail(username);
        if (users.isEmpty()) {
            logger.debug("Query returned no results for user ({})" , username);
            throw new UsernameNotFoundException("User not found");
        }
        Customer user = users.get(0); // contains no GrantedAuthority[]
        Set<GrantedAuthority> dbAuthsSet = new HashSet<>();

        List<GrantedAuthority> dbAuths = new ArrayList<>(dbAuthsSet);
        dbAuths.add(new SimpleGrantedAuthority(user.getRole()));

        return new User(username, user.getPwd(), dbAuths);
    }
}
