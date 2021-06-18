package io.kodlama.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.kodlama.hrms.business.abstracts.SchoolService;
import io.kodlama.hrms.core.utilities.results.AllDataResult;
import io.kodlama.hrms.core.utilities.results.DataResult;
import io.kodlama.hrms.core.utilities.results.ErrorResult;
import io.kodlama.hrms.core.utilities.results.Result;
import io.kodlama.hrms.core.utilities.results.SuccessDataResult;
import io.kodlama.hrms.dataAccess.abstracts.SchoolDao;
import io.kodlama.hrms.dataAccess.abstracts.SchoolTypeDao;
import io.kodlama.hrms.entities.concretes.School;
import io.kodlama.hrms.entities.dtos.SchoolAddDto;

@Service
public class SchoolManager implements SchoolService {
    private final SchoolDao schoolDao;
    private final SchoolTypeDao schoolTypeDao;

    @Autowired
    public SchoolManager(SchoolDao schoolDao, SchoolTypeDao schoolTypeDao) {
        this.schoolDao = schoolDao;
        this.schoolTypeDao = schoolTypeDao;
    }

    public DataResult<List<School>> getAll() {
        return new SuccessDataResult<List<School>>(this.schoolDao.findAll());
    }

    public List<Result> add(SchoolAddDto schoolAddDto) {
        AllDataResult allDataResult = checkSchool(schoolAddDto);
        if (!allDataResult.isSuccess())
            return allDataResult.getErrorResults();

        School school = new School();
        school.setName(schoolAddDto.getName());
        school.setSchoolType(this.schoolTypeDao.findById(schoolAddDto.getSchoolTypeId()).get());
        school.setWebSite(schoolAddDto.getWebSite());
        school.setAvatar(schoolAddDto.getAvatar());

        this.schoolDao.save(school);
        return allDataResult.getSuccessResults();
    }

    private AllDataResult checkSchool(SchoolAddDto schoolAddDto) {
        AllDataResult allDataResult = new AllDataResult();

        if (schoolAddDto.getName() == null)
            allDataResult.addResult(new ErrorResult("ad boş gecilmez"));
        if (schoolAddDto.getSchoolTypeId() == 0)
            allDataResult.addResult(new ErrorResult("id boş olamaz"));
        if (this.schoolTypeDao.findById(schoolAddDto.getSchoolTypeId()) == null)
            allDataResult.addResult(new ErrorResult(schoolAddDto.getSchoolTypeId() + " id tanımsız"));

        return allDataResult;
    }

}
