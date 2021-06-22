package io.kodlama.hrms.business.concretes;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import io.kodlama.hrms.business.abstracts.PhotoService;
import io.kodlama.hrms.core.adapters.abstracts.ImageService;
import io.kodlama.hrms.core.utilities.results.AllDataResult;
import io.kodlama.hrms.core.utilities.results.DataResult;
import io.kodlama.hrms.core.utilities.results.Result;
import io.kodlama.hrms.core.utilities.results.SuccessDataResult;
import io.kodlama.hrms.dataAccess.abstracts.PhotoDao;
import io.kodlama.hrms.entities.concretes.Photo;

@Service
public class PhotoManager implements PhotoService {
    private final PhotoDao photoDao;
    public final ImageService imageService;

    @Autowired
    public PhotoManager(PhotoDao photoDao, ImageService imageService) {
        this.photoDao = photoDao;
        this.imageService = imageService;
    }

    public DataResult<List<Photo>> getAll() {
        return new SuccessDataResult<List<Photo>>(this.photoDao.findAll());
    }

    public List<Result> add(MultipartFile file, int candidateUserId) {
        AllDataResult allDataResult = checkPhoto(file, candidateUserId);
        imageService.save(file);

        return allDataResult.getSuccessResults();
    }

    private AllDataResult checkPhoto(MultipartFile file, int candidateUserId) {
        return null;
    }
}
