package in.ushatech.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "student", schema = "jpa")
public class Student
{
    @Id
    @Column(name = "student_id", nullable = false, length = 50)
    private String studentId;

    @Column(name = "student_name", length = 50)
    private String studentName;

    @Column(name = "student_mobile")
    private Integer studentMobile;

    @Column(name = "student_address", length = 50)
    private String studentAddress;

}