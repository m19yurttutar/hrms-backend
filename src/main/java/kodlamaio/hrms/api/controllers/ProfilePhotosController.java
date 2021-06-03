package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.ProfilePhotoService;
import kodlamaio.hrms.core.utilities.adapters.cloudinaryAdapter.CloudinaryService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.entities.concretes.ProfilePhoto;
import kodlamaio.hrms.entities.dtos.ProfilePhotoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/api/cloudinary")
public class ProfilePhotosController {

    private final CloudinaryService cloudinaryService;
    private final ProfilePhotoService profilePhotoService;

    @Autowired
    public ProfilePhotosController(ProfilePhotoService profilePhotoService, CloudinaryService cloudinaryService) {
        this.profilePhotoService = profilePhotoService;
        this.cloudinaryService = cloudinaryService;
    }

    @PostMapping("/upload")
    public DataResult<Map> upload(@RequestParam MultipartFile multipartFile) throws IOException {
        DataResult<Map> result = cloudinaryService.upload(multipartFile);
        profilePhotoService.add(new ProfilePhotoDto((String) result.getData().get("original_filename"), (String) result.getData().get("url"), (String) result.getData().get("public_id")));
        return result;
    }

    @DeleteMapping("/delete")
    public DataResult<Map> delete(@RequestParam int id) throws IOException{
        if(!profilePhotoService.exist(id).isSuccess()){
            return new ErrorDataResult<>("Bu id numarasına sahip fotoğraf bulunamadı.");
        }
        ProfilePhoto profilePhoto = profilePhotoService.getById(id).getData();
        return cloudinaryService.delete(profilePhoto.getPublicId());
    }
}
