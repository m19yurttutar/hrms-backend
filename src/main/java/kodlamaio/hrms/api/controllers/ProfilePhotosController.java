package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.ProfilePhotoService;
import kodlamaio.hrms.core.utilities.adapters.cloudinaryAdapter.CloudinaryService;
import kodlamaio.hrms.entities.concretes.ProfilePhoto;
import kodlamaio.hrms.entities.dtos.ProfilePhotoDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> upload(@RequestParam MultipartFile multipartFile) throws IOException {
        var result = cloudinaryService.upload(multipartFile);
        profilePhotoService.update(new ProfilePhotoDto((String) result.getData().get("original_filename"), (String) result.getData().get("url"), (String) result.getData().get("public_id")));

        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam int id) throws IOException{
        ProfilePhoto profilePhoto = profilePhotoService.getById(id).getData();
        var result = cloudinaryService.delete(profilePhoto.getPublicId());

        profilePhotoService.update(new ProfilePhotoDto("default_profile_photo", "https://res.cloudinary.com/dxahez1o6/image/upload/v1623099446/mqkyb7zxgnmnwwnlxhwf.jpg", "mqkyb7zxgnmnwwnlxhwf"));

        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }
}
