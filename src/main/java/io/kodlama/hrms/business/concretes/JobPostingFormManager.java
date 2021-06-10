package io.kodlama.hrms.business.concretes;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import io.kodlama.hrms.business.abstracts.JobPostingFormService;
import io.kodlama.hrms.core.utilities.results.DataResult;
import io.kodlama.hrms.core.utilities.results.Result;
import io.kodlama.hrms.core.utilities.results.SuccessDataResult;
import io.kodlama.hrms.core.utilities.results.SuccessResult;
import io.kodlama.hrms.dataAccess.abstracts.JobPostingFormDao;
import io.kodlama.hrms.entities.concretes.JobPostingForm;

@Service
public class JobPostingFormManager implements JobPostingFormService {

    private final JobPostingFormDao jobPostingFormDao;

    public JobPostingFormManager(JobPostingFormDao jobPostingFormDao) {
        this.jobPostingFormDao = jobPostingFormDao;
    }

    @Override
    public Result add(JobPostingForm jobPostingForm) {
        // Result result = BusinessEngine.run(emptyJobPostingForm(jobPostingForm));

        // if (!result.isSuccess())
        // return new ErrorResult();

        this.jobPostingFormDao.save(jobPostingForm);
        return new SuccessResult();
    }

    @Override
    public Result formClose(JobPostingForm jobPostingForm) {
        return null;
    }

    @Override
    public DataResult<List<JobPostingForm>> getAll() {

        return new SuccessDataResult<List<JobPostingForm>>(jobPostingFormDao.findAll());
    }

    @Override
    public DataResult<List<JobPostingForm>> getByIsOpenFalse() {

        return new SuccessDataResult<List<JobPostingForm>>(this.jobPostingFormDao.getByIsOpenFalse());
    }

    @Override
    public DataResult<List<JobPostingForm>> getByJobPositionContains(String jobPosition) {

        return new SuccessDataResult<List<JobPostingForm>>();
    }

    @Override
    public DataResult<List<JobPostingForm>> getAllDateSorted() {
        Sort sort = Sort.by(Sort.Direction.DESC);
        return new SuccessDataResult<List<JobPostingForm>>(this.jobPostingFormDao.findAll(sort));
    }

    @Override
    public DataResult<List<JobPostingForm>> getByIsOpenTrue() {
        return new SuccessDataResult<List<JobPostingForm>>(this.jobPostingFormDao.getByIsOpenTrue());
    }

    @Override
    public DataResult<List<JobPostingForm>> getByEmployerUserCompanyNameContains(String companyName) {
        return new SuccessDataResult<List<JobPostingForm>>(
                this.jobPostingFormDao.getByEmployerUserCompanyNameContains(companyName));
    }

}
