package io.kodlama.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "employer_users")
@AllArgsConstructor
@NoArgsConstructor

public class EmployerUser extends User {

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "phone_number")
    private String companyPhone;

    @Column(name = "domain_mail")
    private String domainMail;

    @Column(name = "web_address")
    private String web_Address;
}
