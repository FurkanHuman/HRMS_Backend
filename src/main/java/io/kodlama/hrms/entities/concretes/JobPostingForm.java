package io.kodlama.hrms.entities.concretes;

import java.time.LocalDateTime;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.*;

@Data
@Entity
@Table(name = "jobPostingForms")
@AllArgsConstructor
@NoArgsConstructor

public class JobPostingForm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonIgnore
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "definition") // içerik
    private String definition;

    @Column(name = "openJobPositionQuantity")
    private int openJobPositionQuantity;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cities", nullable = false)

    private City cities;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "salaryScales", nullable = false)
    private Salary salaries;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "job_positions", nullable = false, referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private JobPosition jobPosition;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employer_users", nullable = false, referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private EmployerUser employerUser;

    @Column(name = "endDate")
    private LocalDateTime endDate;

    @Column(name = "isopen")
    private Boolean isOpen;
}
