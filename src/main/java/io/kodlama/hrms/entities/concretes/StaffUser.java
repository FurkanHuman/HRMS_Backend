package io.kodlama.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "staff_users")
@AllArgsConstructor
@NoArgsConstructor

public class StaffUser extends User {

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surName;

    @JsonIgnore
    @Column(name = "verify")
    private boolean verify;
}
