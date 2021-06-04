package io.kodlama.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.kodlama.hrms.business.abstracts.CityService;
import io.kodlama.hrms.core.utilities.BusinessEngine.BusinessEngine;
import io.kodlama.hrms.core.utilities.results.DataResult;
import io.kodlama.hrms.core.utilities.results.ErrorResult;
import io.kodlama.hrms.core.utilities.results.Result;
import io.kodlama.hrms.core.utilities.results.SuccessDataResult;
import io.kodlama.hrms.core.utilities.results.SuccessResult;
import io.kodlama.hrms.dataAccess.abstracts.CityDao;
import io.kodlama.hrms.entities.concretes.City;

@Service
public class CityManager implements CityService {
    private final CityDao cityDao;

    @Autowired
    public CityManager(CityDao cityDao) {
        this.cityDao = cityDao;
    }

    @Override
    public Result add(City city) {
        Result result = BusinessEngine.run(existsCity(city), namelength(city.getName()));

        if (!result.isSuccess())
            return new ErrorResult();

        cityDao.save(city);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<City>> getAll() {
        return new SuccessDataResult<List<City>>(this.cityDao.findAll());
    }

    private Result namelength(String name) {
        if (name.length() > 3)
            return new SuccessResult();
        return new ErrorResult();
    }

    private Result existsCity(City city) {
        if (cityDao.existsByname(city.getName()))
            return new ErrorResult();
        return new SuccessResult();
    }

}
