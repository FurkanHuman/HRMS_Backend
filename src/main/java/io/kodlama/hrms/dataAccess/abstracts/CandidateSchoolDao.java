package io.kodlama.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.kodlama.hrms.entities.concretes.CandidateSchool;

public interface CandidateSchoolDao extends JpaRepository<CandidateSchool, Integer> {

    List<CandidateSchool> findByCandidateId(int candidateId);

}
