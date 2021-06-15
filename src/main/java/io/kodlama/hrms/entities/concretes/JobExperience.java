package io.kodlama.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "job_experiences")

public class JobExperience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne()
    @JoinColumn(name = "candidate_id")
    private CandidateUser candidate;

    @ManyToOne()
    @JoinColumn(name = "employer_id")
    private EmployerUser employer;

    @ManyToOne()
    @JoinColumn(name = "job_position_id")
    private JobPosition jobPosition;

    @Column(name = "exp_start_date")
    private LocalDate expStartDate;

    @Column(name = "exp_end_date")
    private LocalDate expEndDate;

    @Column(name = "state")
    private boolean state;

}
