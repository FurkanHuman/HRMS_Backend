package io.kodlama.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import io.kodlama.hrms.entities.concretes.UserVerify;

public interface UserVerifyDao extends JpaRepository<UserVerify, Integer> {

}
