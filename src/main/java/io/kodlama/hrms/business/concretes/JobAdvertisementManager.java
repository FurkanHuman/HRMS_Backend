package io.kodlama.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.kodlama.hrms.business.abstracts.JobAdvertisementService;
import io.kodlama.hrms.core.utilities.results.AllDataResult;
import io.kodlama.hrms.core.utilities.results.DataResult;
import io.kodlama.hrms.core.utilities.results.ErrorResult;
import io.kodlama.hrms.core.utilities.results.Result;
import io.kodlama.hrms.core.utilities.results.SuccessDataResult;
import io.kodlama.hrms.core.utilities.results.SuccessResult;
import io.kodlama.hrms.dataAccess.abstracts.CityDao;
import io.kodlama.hrms.dataAccess.abstracts.EmployerUserDao;
import io.kodlama.hrms.dataAccess.abstracts.JobAdvertisementDao;
import io.kodlama.hrms.dataAccess.abstracts.JobPositionDao;
import io.kodlama.hrms.entities.concretes.jobAdvertisement;
import io.kodlama.hrms.entities.dtos.JobAdvertisementAddDto;
import io.kodlama.hrms.entities.dtos.JobAdvertisementGetDto;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {
    private final JobAdvertisementDao jobAdvertisementDao;
    private final CityDao cityDao;
    private final JobPositionDao jobPositionDao;
    private final EmployerUserDao employerUserDao;

    @Autowired
    public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao, CityDao cityDao,
            JobPositionDao jobPositionDao, EmployerUserDao employerUserDao) {
        this.jobAdvertisementDao = jobAdvertisementDao;
        this.cityDao = cityDao;
        this.jobPositionDao = jobPositionDao;
        this.employerUserDao = employerUserDao;
    }

    @Override
    public List<Result> addJobAdvertisement(JobAdvertisementAddDto advertismentAddDto) {
        AllDataResult allDataResult = checkJobAdvertisement(advertismentAddDto);

        if (!allDataResult.isSuccess()) {
            allDataResult.addResult(new ErrorResult("kayıt başarısız"));
            return allDataResult.getErrorResults();
        }

        jobAdvertisement advertisement = new jobAdvertisement();

        advertisement.setCity(this.cityDao.findById(advertismentAddDto.getCity()).get());
        advertisement.setEmployer(this.employerUserDao.findById(advertismentAddDto.getCompanyId()).get());
        advertisement.setJobPosition(this.jobPositionDao.findById(advertismentAddDto.getJobPositionId()).get());
        advertisement.setDefinition(advertismentAddDto.getDefinition());
        advertisement.setEndDate(advertismentAddDto.getEndDate());
        advertisement.setMaxSalary(advertismentAddDto.getMaxSalaries());
        advertisement.setMinSalary(advertismentAddDto.getMinSalaries());
        advertisement.setTitle(advertismentAddDto.getTitle());
        advertisement.setPositionQuantity(advertismentAddDto.getOpenJobPositionQuantity());

        this.jobAdvertisementDao.save(advertisement);

        allDataResult.addResult(new SuccessResult("kayıt BAŞARILI"));

        return allDataResult.getSuccessResults();
    }

    @Override
    public List<Result> disableJobAdvertisement(int jobAdvertisementId, boolean state) {
        AllDataResult allDataResult = checkId(jobAdvertisementId);
        if (!allDataResult.isSuccess())
            return allDataResult.getErrorResults();
        jobAdvertisement jobAdvertisement = jobAdvertisementDao.getById(jobAdvertisementId);

        jobAdvertisement.setOpen(state);

        this.jobAdvertisementDao.save(jobAdvertisement);
        return allDataResult.getSuccessResults();

    }

    private AllDataResult checkId(int jobAdvertisementId) {
        AllDataResult allDataResult = new AllDataResult();
        if (!this.jobAdvertisementDao.findById(jobAdvertisementId).isPresent())
            allDataResult.addResult(new ErrorResult("id bulunamadı"));
        return allDataResult;
    }

    private AllDataResult checkJobAdvertisement(JobAdvertisementAddDto advertisementAddDto) {

        AllDataResult allDataResult = new AllDataResult();

        if (this.employerUserDao.findById(advertisementAddDto.getCompanyId()).isEmpty())
            allDataResult.addResult(new ErrorResult("şirket employer ıd bulunamadı"));

        if (this.cityDao.findById(advertisementAddDto.getCity()).isEmpty())
            allDataResult.addResult(new ErrorResult("city id tanımsız"));

        if (this.jobPositionDao.findById(advertisementAddDto.getJobPositionId()).isEmpty())
            allDataResult.addResult(new ErrorResult("job posisition id yok"));

        if (advertisementAddDto.getTitle().length() < 10)
            allDataResult.addResult(new ErrorResult("title en az 10 karakter olmalı"));

        return allDataResult;

    }

    @Override
    public DataResult<List<JobAdvertisementGetDto>> getJobAdvertisement(int jobAdvertisementId) {
        return new SuccessDataResult<List<JobAdvertisementGetDto>>(
                this.jobAdvertisementDao.getJobAdvertisement(jobAdvertisementId));
    }

    @Override
    public DataResult<List<JobAdvertisementGetDto>> getAllJobAdvertisement() {
        return new SuccessDataResult<List<JobAdvertisementGetDto>>(this.jobAdvertisementDao.getAllJobAdvertisement());
    }

    @Override
    public DataResult<List<JobAdvertisementGetDto>> getJobAdvertisementByJobPositionId(int jobPositionId) {
        return new SuccessDataResult<List<JobAdvertisementGetDto>>(
                this.jobAdvertisementDao.getJobAdvertisementByjobPositionId(jobPositionId));
    }

    @Override
    public DataResult<List<JobAdvertisementGetDto>> getJobAdvertisementByCityId(int cityId) {
        return new SuccessDataResult<List<JobAdvertisementGetDto>>(
                this.jobAdvertisementDao.getJobAdvertisementByCityId(cityId));
    }

    // @Override
    // public DataResult<List<JobAdvertisementGetDto>>
    // getJobAdvertisementByDateRange(LocalDate startDate,
    // LocalDate endDate) {
    // return new
    // SuccessDataResult<List<JobAdvertisementGetDto>>(this.jobAdvertisementDao
    // .getAllJobAdvertisementByDateRange(GlobalMethot.convertToDateUsingInstant(startDate),
    // GlobalMethot.convertToDateUsingInstant(endDate)));
    // }
}
