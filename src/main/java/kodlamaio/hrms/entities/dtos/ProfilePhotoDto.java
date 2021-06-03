package kodlamaio.hrms.entities.dtos;

import kodlamaio.hrms.core.entities.abstracts.Dto;
import lombok.Data;

@Data
public class ProfilePhotoDto implements Dto {
    private String name;
    private String url;
    private String publicId;

    public ProfilePhotoDto(String name, String url, String publicId) {
        this.name = name;
        this.url = url;
        this.publicId = publicId;
    }
}
