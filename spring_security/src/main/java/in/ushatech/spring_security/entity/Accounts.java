package in.ushatech.spring_security.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;

@lombok.Getter
@lombok.Setter
@Entity
@Table(name = "accounts", schema = "eazybank")
public class Accounts
{
    @Id
    @Column(name = "account_number", nullable = false)
    private Integer accountNumber;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @Column(name = "account_type", nullable = false, length = 100)
    private String accountType;

    @Column(name = "branch_address", nullable = false, length = 200)
    private String branchAddress;

    @Column(name = "create_dt")
    private LocalDate createDt;

}