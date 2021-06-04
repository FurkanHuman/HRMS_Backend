package io.kodlama.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import io.kodlama.hrms.entities.concretes.JobPostingForm;

public interface JobPostingFormDao extends JpaRepository<JobPostingForm, Integer> {

}
