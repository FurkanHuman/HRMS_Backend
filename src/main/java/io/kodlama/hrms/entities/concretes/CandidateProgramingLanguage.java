package io.kodlama.hrms.entities.concretes;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "candidate_programing_languages")

public class CandidateProgramingLanguage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne()
    @JoinColumn(name = "candidate_id")
    private CandidateUser candidate;

    @ManyToOne()
    @JoinColumn(name = "p_languages_id")
    private ProgramingLanguage programingLanguage;

    @Column(name = "comment")
    private String comment;

}
