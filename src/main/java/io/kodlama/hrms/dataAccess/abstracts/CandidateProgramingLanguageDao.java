package io.kodlama.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.kodlama.hrms.entities.concretes.CandidateProgramingLanguage;

public interface CandidateProgramingLanguageDao extends JpaRepository<CandidateProgramingLanguage, Integer> {

    List<CandidateProgramingLanguage> findByCandidateId(int candidateId);

}
