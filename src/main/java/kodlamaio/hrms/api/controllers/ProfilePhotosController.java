package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.ProfilePhotoService;
import kodlamaio.hrms.core.utilities.adapters.cloudinaryAdapter.CloudinaryService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.ProfilePhoto;
import kodlamaio.hrms.entities.dtos.ProfilePhotoDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/profilePhotos")
public class ProfilePhotosController {

    private final CloudinaryService cloudinaryService;
    private final ProfilePhotoService profilePhotoService;

    @Autowired
    public ProfilePhotosController(ProfilePhotoService profilePhotoService, CloudinaryService cloudinaryService) {
        this.profilePhotoService = profilePhotoService;
        this.cloudinaryService = cloudinaryService;
    }

    @PostMapping("/upload")
    public Result upload(@RequestParam MultipartFile multipartFile) throws IOException {

        var cloudinaryResult = cloudinaryService.upload(multipartFile);

        return profilePhotoService.update(new ProfilePhotoDto((String) cloudinaryResult.getData().get("original_filename"), (String) cloudinaryResult.getData().get("url"), (String) cloudinaryResult.getData().get("public_id")));
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestParam int id) throws IOException{

        ProfilePhoto profilePhoto = profilePhotoService.getById(id).getData();

        cloudinaryService.delete(profilePhoto.getPublicId());

        return profilePhotoService.update(new ProfilePhotoDto("default_profile_photo", "https://res.cloudinary.com/dxahez1o6/image/upload/v1623099446/mqkyb7zxgnmnwwnlxhwf.jpg", "mqkyb7zxgnmnwwnlxhwf"));
    }
}
