package io.kodlama.hrms.entities.concretes;

import java.sql.Date;

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
    @JoinColumn(name = "cities", nullable = false, referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private City[] cities;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "salaryScales", nullable = false, referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Salary[] salaries;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "job_positions", nullable = false, referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private JobPosition jobPosition;

    @Column(name = "endDate")
    private Date endDate;
}
