package io.kodlama.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import io.kodlama.hrms.entities.concretes.Verify;

public interface VerifyDao extends JpaRepository<Verify, Integer> {

}
