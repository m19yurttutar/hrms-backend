package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.ProfilePhotoService;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.ProfilePhotoDao;
import kodlamaio.hrms.entities.concretes.ProfilePhoto;
import kodlamaio.hrms.entities.dtos.ProfilePhotoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfilePhotoManager implements ProfilePhotoService {

    private final ProfilePhotoDao profilePhotoDao;

    @Autowired
    public ProfilePhotoManager(ProfilePhotoDao profilePhotoDao) {
        this.profilePhotoDao = profilePhotoDao;
    }

    @Override
    public DataResult<List<ProfilePhoto>> getAll() {
        return new SuccessDataResult<>(profilePhotoDao.findAll());
    }

    @Override
    public DataResult<ProfilePhoto> getById(Integer id) {
        return new SuccessDataResult<>(profilePhotoDao.getOne(id));
    }

    @Override
    public Result add(ProfilePhoto profilePhoto) {
        profilePhotoDao.save(profilePhoto);
        return new SuccessResult();
    }

    @Override
    public Result delete(ProfilePhoto profilePhoto) {
        profilePhotoDao.delete(profilePhoto);
        return new SuccessResult();
    }

    @Override
    public Result update(ProfilePhotoDto profilePhotoDto) {
        ProfilePhoto profilePhoto = profilePhotoDtoToProfilePhotoConverter(profilePhotoDto);
        profilePhotoDao.save(profilePhoto);
        return new SuccessResult();
    }

    @Override
    public Result exist(Integer id) {
        if (!profilePhotoDao.existsById(id)){
            return new ErrorResult();

        }
        return new SuccessResult();
    }

    //This method converts the ProfilePhotoDto object into a form that the database will recognize.
    private ProfilePhoto profilePhotoDtoToProfilePhotoConverter(ProfilePhotoDto profilePhotoDto){
        //This value will hold the profilePhotoId of the logged-in user when the JSON Web Token was written.
        int profilePhotoId = 3;

        return new ProfilePhoto(profilePhotoId, profilePhotoDto.getName(), profilePhotoDto.getUrl(), profilePhotoDto.getPublicId());
    }
}
