package io.kodlama.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import io.kodlama.hrms.entities.concretes.StaffUser;

public interface StaffUserDao extends JpaRepository<StaffUser, Integer> {

}
