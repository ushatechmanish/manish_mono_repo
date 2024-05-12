package in.ushatech.spring_security.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@lombok.Getter
@lombok.Setter
@Entity
@Table(name = "contact_messages", schema = "eazybank")
public class ContactMessage
{
    @Id
    @Column(name = "contact_id", nullable = false, length = 50)
    private String contactId;

    @Column(name = "contact_name", nullable = false, length = 50)
    private String contactName;

    @Column(name = "contact_email", nullable = false, length = 100)
    private String contactEmail;

    @Column(name = "subject", nullable = false, length = 500)
    private String subject;

    @Column(name = "message", nullable = false, length = 2000)
    private String message;

    @Column(name = "create_dt")
    private LocalDate createDt;

}