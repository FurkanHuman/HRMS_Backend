package io.kodlama.hrms.entities.concretes;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "confirm_employer_users")
@AllArgsConstructor
@NoArgsConstructor
public class ConfirmEmployer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private int id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "employer_id")
    private EmployerUser employerUser;

    @JoinColumn(name = "confirmed_staff_user", nullable = true, referencedColumnName = "id")
    @ManyToOne
    private StaffUser staffUser;

    @JsonIgnore
    @Column(name = "verfiy_code", nullable = false)
    private String verifyCode;

    @JsonIgnore
    @Column(name = "created_date", nullable = false)
    private LocalDateTime createdDate;

    @JsonIgnore
    @Column(name = "confirmed_date", nullable = true)
    private LocalDateTime confirmedDate;

    @JsonIgnore
    @Column(name = "is_confirmed", nullable = true)
    private boolean isConfirmed;
}