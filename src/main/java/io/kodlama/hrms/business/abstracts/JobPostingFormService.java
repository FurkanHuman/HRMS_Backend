package io.kodlama.hrms.business.abstracts;

import java.util.List;

import io.kodlama.hrms.core.utilities.results.DataResult;
import io.kodlama.hrms.core.utilities.results.Result;
import io.kodlama.hrms.entities.concretes.JobPostingForm;

public interface JobPostingFormService {

    Result add(JobPostingForm jobPostingForm);

    Result formClose(JobPostingForm jobPostingForm);

    DataResult<List<JobPostingForm>> getAll();

    DataResult<List<JobPostingForm>> getAllDateSorted();

    DataResult<List<JobPostingForm>> getByEmployerUserCompanyNameContains(String companyName);

    DataResult<List<JobPostingForm>> getByIsOpenFalse();

    DataResult<List<JobPostingForm>> getByIsOpenTrue();

    DataResult<List<JobPostingForm>> getByJobPositionContains(String jobPosition);

}
