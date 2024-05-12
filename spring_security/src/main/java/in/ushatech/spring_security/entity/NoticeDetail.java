package in.ushatech.spring_security.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;

@lombok.Getter
@lombok.Setter
@Entity
@Table(name = "notice_details", schema = "eazybank")
public class NoticeDetail
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "notice_id", nullable = false)
    private Integer id;

    @Column(name = "notice_summary", nullable = false, length = 200)
    private String noticeSummary;

    @Column(name = "notice_details", nullable = false, length = 500)
    private String noticeDetails;

    @Column(name = "notic_beg_dt", nullable = false)
    private LocalDate noticBegDt;

    @Column(name = "notic_end_dt")
    private LocalDate noticEndDt;

    @Column(name = "create_dt")
    private LocalDate createDt;

    @Column(name = "update_dt")
    private LocalDate updateDt;

}