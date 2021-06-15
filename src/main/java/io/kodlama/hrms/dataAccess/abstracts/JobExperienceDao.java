package io.kodlama.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.kodlama.hrms.entities.concretes.CandidateUser;
import io.kodlama.hrms.entities.concretes.JobExperience;

public interface JobExperienceDao extends JpaRepository<JobExperience, Integer> {

    List<JobExperience> findByCandidate(CandidateUser candidateUser);

}
