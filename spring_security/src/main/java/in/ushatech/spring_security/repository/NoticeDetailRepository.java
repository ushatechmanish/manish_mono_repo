package in.ushatech.spring_security.repository;

import in.ushatech.spring_security.entity.NoticeDetail;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Component
public interface NoticeDetailRepository extends CrudRepository<NoticeDetail, Integer>
{
    @Query(value = "from NoticeDetail n where CURDATE() BETWEEN noticBegDt AND noticEndDt")
    List<NoticeDetail> findAllActiveNotices();
}
