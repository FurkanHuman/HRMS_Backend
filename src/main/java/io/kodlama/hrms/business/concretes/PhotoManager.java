package io.kodlama.hrms.business.concretes;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import io.kodlama.hrms.business.abstracts.PhotoService;
import io.kodlama.hrms.core.adapters.abstracts.ImageService;
import io.kodlama.hrms.core.utilities.results.AllDataResult;
import io.kodlama.hrms.core.utilities.results.DataResult;
import io.kodlama.hrms.core.utilities.results.ErrorResult;
import io.kodlama.hrms.core.utilities.results.Result;
import io.kodlama.hrms.core.utilities.results.SuccessDataResult;
import io.kodlama.hrms.dataAccess.abstracts.CandidateUserDao;
import io.kodlama.hrms.dataAccess.abstracts.PhotoDao;
import io.kodlama.hrms.entities.concretes.Photo;

@Service
public class PhotoManager implements PhotoService {
    private final PhotoDao photoDao;
    private final ImageService imageService;
    private final CandidateUserDao candidateUserDao;

    @Autowired
    public PhotoManager(PhotoDao photoDao, ImageService imageService, CandidateUserDao candidateUserDao) {
        this.photoDao = photoDao;
        this.imageService = imageService;
        this.candidateUserDao = candidateUserDao;
    }

    public DataResult<List<Photo>> getAll() {
        return new SuccessDataResult<List<Photo>>(this.photoDao.findAll());
    }

    public List<Result> add(MultipartFile file, int candidateUserId) {
        AllDataResult allDataResult = checkPhoto(file, candidateUserId);
        if (!allDataResult.isSuccess())
            return allDataResult.getErrorResults();

        String photoLink = imageService.save(file);
        if (photoLink == null) {
            allDataResult.addResult(new ErrorResult("foto uygun değil"));
            return allDataResult.getErrorResults();
        }

        Photo photo = new Photo();
        photo.setUserId(candidateUserId);
        photo.setLink(photoLink);
        photoDao.save(photo);

        return allDataResult.getSuccessResults();
    }

    public List<Result> delete(int userId) {
        AllDataResult allDataResult = checkPhotoDatabase(userId);
        if (!allDataResult.isSuccess())
            return allDataResult.getErrorResults();

        List<Photo> userPhotos = this.photoDao.findByUserId(userId);

        for (Photo photo : userPhotos) {

            this.imageService.remove(urlToId(photo.getLink())).equals("ok");
            this.photoDao.delete(photo);
        }
        return allDataResult.getSuccessResults();
    }

    private AllDataResult checkPhoto(MultipartFile file, int candidateUserId) {
        AllDataResult allDataResult = new AllDataResult();

        if (file.isEmpty())
            allDataResult.addResult(new ErrorResult("dosya boş"));
        if (!this.candidateUserDao.existsById(candidateUserId))
            allDataResult.addResult(new ErrorResult("candidade id boş"));
        if (this.photoDao.existsByUserId(candidateUserId))
            allDataResult.addResult(new ErrorResult("sadece tek fotoğraf"));
        return allDataResult;
    }

    private AllDataResult checkPhotoDatabase(int candidateUserId) {
        AllDataResult allDataResult = new AllDataResult();

        if (this.photoDao.getByUserId(candidateUserId) == null)
            allDataResult.addResult(new ErrorResult("veri yok"));

        if (this.photoDao.getByUserId(candidateUserId).getLink().isEmpty())
            allDataResult.addResult(new ErrorResult("link bulunamadı"));
        return allDataResult;
    }

    private String urlToId(String link) {

        Pattern p = Pattern.compile("^.*/([a-zA-Z-0-9]+)...*$");
        Matcher m = p.matcher(link);
        if (m.find())
            return m.group(1);
        return null;
    }

}
