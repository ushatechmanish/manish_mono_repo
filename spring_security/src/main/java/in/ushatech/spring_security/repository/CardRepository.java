package in.ushatech.spring_security.repository;

import in.ushatech.spring_security.entity.Card;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Component
public interface CardRepository extends CrudRepository<Card, Integer>
{
    List<Card> findByCustomerId(int id);
}
