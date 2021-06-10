package io.kodlama.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.kodlama.hrms.entities.concretes.JobPostingForm;

public interface JobPostingFormDao extends JpaRepository<JobPostingForm, Integer> {

    // List<JobPostingForm> getByCompanyNameContains(String companyName);

    List<JobPostingForm> getByIsOpenFalse();

    List<JobPostingForm> getByIsOpenTrue();

    List<JobPostingForm> getByEmployerUserCompanyNameContains(String companyName);

    // List<JobPostingForm> getByJobPositionContains();

}
