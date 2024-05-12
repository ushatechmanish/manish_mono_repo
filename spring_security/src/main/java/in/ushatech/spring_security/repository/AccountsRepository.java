package in.ushatech.spring_security.repository;

import in.ushatech.spring_security.entity.Accounts;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface AccountsRepository extends CrudRepository<Accounts, Integer>
{
    Accounts findByCustomerId(int id);
}
