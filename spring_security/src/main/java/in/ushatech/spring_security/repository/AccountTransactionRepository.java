package in.ushatech.spring_security.repository;

import in.ushatech.spring_security.entity.AccountTransaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Component
public interface AccountTransactionRepository extends CrudRepository<AccountTransaction, Integer>
{
    List<AccountTransaction> findByCustomerIdOrderByTransactionDtDesc(int id);
}
