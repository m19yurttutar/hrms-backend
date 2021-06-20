package kodlamaio.hrms.entities.dtos;

import kodlamaio.hrms.core.entities.abstracts.Dto;
import lombok.Data;

@Data
public class JobSeekerDto implements Dto {
    private String firstName;
    private String lastName;
    private int genderId;
    private String nationalIdentityNumber;
    private String birthDate;
    private String email;
    private String password;
    private String confirmPassword;
}
