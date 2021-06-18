package io.kodlama.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.kodlama.hrms.business.abstracts.CandidateSchoolService;
import io.kodlama.hrms.core.utilities.results.DataResult;
import io.kodlama.hrms.core.utilities.results.SuccessDataResult;
import io.kodlama.hrms.dataAccess.abstracts.CandidateSchoolDao;
import io.kodlama.hrms.entities.concretes.CandidateSchool;

@Service
public class CandidateSchoolManager implements CandidateSchoolService {
    private final CandidateSchoolDao candidateSchoolDao;

    @Autowired
    public CandidateSchoolManager(CandidateSchoolDao candidateSchoolDao) {
        this.candidateSchoolDao = candidateSchoolDao;
    }

    public DataResult<List<CandidateSchool>> getAll() {

        return new SuccessDataResult<List<CandidateSchool>>(this.candidateSchoolDao.findAll());
    }

}
