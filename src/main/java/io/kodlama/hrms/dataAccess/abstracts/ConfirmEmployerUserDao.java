package io.kodlama.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import io.kodlama.hrms.entities.concretes.ConfirmEmployerUser;

public interface ConfirmEmployerUserDao extends JpaRepository<ConfirmEmployerUser, Integer> {

}
