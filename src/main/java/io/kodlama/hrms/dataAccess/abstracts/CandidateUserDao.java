package io.kodlama.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import io.kodlama.hrms.entities.concretes.CandidateUser;

public interface CandidateUserDao extends JpaRepository<CandidateUser, Integer> {

}
