package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.ProfilePhoto;
import kodlamaio.hrms.entities.dtos.ProfilePhotoDto;

import java.util.List;

public interface ProfilePhotoService {
    DataResult<List<ProfilePhoto>> getAll();
    DataResult<ProfilePhoto> getById(Integer id);
    Result add(ProfilePhoto profilePhoto);
    Result delete(ProfilePhoto profilePhoto);
    Result update(ProfilePhotoDto profilePhotoDto);
    Result exist(Integer id);
}
