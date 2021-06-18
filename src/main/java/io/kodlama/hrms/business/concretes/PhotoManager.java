package io.kodlama.hrms.business.concretes;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.kodlama.hrms.business.abstracts.PhotoService;
import io.kodlama.hrms.core.utilities.results.DataResult;
import io.kodlama.hrms.core.utilities.results.Result;
import io.kodlama.hrms.core.utilities.results.SuccessDataResult;
import io.kodlama.hrms.dataAccess.abstracts.PhotoDao;
import io.kodlama.hrms.entities.concretes.Photo;

@Service
public class PhotoManager implements PhotoService {
    private final PhotoDao photoDao;

    @Autowired
    public PhotoManager(PhotoDao photoDao) {
        this.photoDao = photoDao;
    }

    public DataResult<List<Photo>> getAll() {
        return new SuccessDataResult<List<Photo>>(this.photoDao.findAll());
    }

    public List<Result> add(File file, int candidateUserId) {
        // TODO buraya bakılacak
        return null;
    }
}
