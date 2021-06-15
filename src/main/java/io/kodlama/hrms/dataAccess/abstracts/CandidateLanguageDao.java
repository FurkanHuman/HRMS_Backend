package io.kodlama.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.kodlama.hrms.entities.concretes.CandidateLanguage;

public interface CandidateLanguageDao extends JpaRepository<CandidateLanguage, Integer> {

    List<CandidateLanguage> findByCandidateId(int candidateId);

}
