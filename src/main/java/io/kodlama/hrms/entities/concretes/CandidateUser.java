package io.kodlama.hrms.entities.concretes;

import java.sql.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "candidate_users")
@AllArgsConstructor
@NoArgsConstructor

public class CandidateUser extends User {

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surName;

    @Column(name = "national_identity")
    private String nationalIdentity;

    @Column(name = "birth_date")
    private Date birthDate;

    @JsonIgnore
    @Column(name = "verify")
    private boolean verify;

}
