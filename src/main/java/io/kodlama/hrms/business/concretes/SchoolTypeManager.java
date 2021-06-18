package io.kodlama.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.kodlama.hrms.business.abstracts.SchoolTypeService;
import io.kodlama.hrms.core.utilities.results.AllDataResult;
import io.kodlama.hrms.core.utilities.results.DataResult;
import io.kodlama.hrms.core.utilities.results.ErrorResult;
import io.kodlama.hrms.core.utilities.results.Result;
import io.kodlama.hrms.core.utilities.results.SuccessDataResult;
import io.kodlama.hrms.dataAccess.abstracts.SchoolTypeDao;
import io.kodlama.hrms.entities.concretes.SchoolType;
import io.kodlama.hrms.entities.dtos.SchoolTypeDto;

@Service
public class SchoolTypeManager implements SchoolTypeService {
    private final SchoolTypeDao schoolTypeDao;

    @Autowired
    public SchoolTypeManager(SchoolTypeDao schoolTypeDao) {
        this.schoolTypeDao = schoolTypeDao;
    }

    public DataResult<List<SchoolType>> getAll() {
        return new SuccessDataResult<List<SchoolType>>(this.schoolTypeDao.findAll());
    }

    public List<Result> add(SchoolTypeDto schoolTypeDto) {
        AllDataResult allDataResult = checkSchoolType(schoolTypeDto);

        if (!allDataResult.isSuccess())
            return allDataResult.getErrorResults();

        SchoolType schoolType = new SchoolType();
        schoolType.setName(schoolTypeDto.getName());

        this.schoolTypeDao.save(schoolType);
        return allDataResult.getSuccessResults();
    }

    private AllDataResult checkSchoolType(SchoolTypeDto schoolTypeDto) {
        AllDataResult allDataResult = new AllDataResult();

        if (schoolTypeDto.getName().isBlank())
            allDataResult.addResult(new ErrorResult("Ad boş geçilmez"));

        if (this.schoolTypeDao.findByName(schoolTypeDto.getName()) != null)
            allDataResult.addResult(new ErrorResult("aynısı var"));

        return allDataResult;

    }

}
