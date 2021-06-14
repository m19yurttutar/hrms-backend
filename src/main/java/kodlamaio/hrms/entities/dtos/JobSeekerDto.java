package kodlamaio.hrms.entities.dtos;

import kodlamaio.hrms.core.entities.abstracts.Dto;
import kodlamaio.hrms.entities.concretes.Gender;
import lombok.Data;

import java.time.LocalDate;

@Data
public class JobSeekerDto implements Dto {
    private String firstName;
    private String lastName;
    private Gender gender;
    private String nationalIdentityNumber;
    private String birthDate;
    private String email;
    private String password;
    private String confirmPassword;
}
