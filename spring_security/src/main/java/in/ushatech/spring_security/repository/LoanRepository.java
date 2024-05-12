package in.ushatech.spring_security.repository;

import in.ushatech.spring_security.entity.Loan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Component
public interface LoanRepository extends CrudRepository<Loan, Integer>
{
    List<Loan> findByCustomerIdOrderByStartDtDesc(int id);
}
