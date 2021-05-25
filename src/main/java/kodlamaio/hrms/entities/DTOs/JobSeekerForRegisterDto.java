package kodlamaio.hrms.entities.DTOs;

import kodlamaio.hrms.entities.abstracts.Dto;
import lombok.Data;

@Data
public class JobSeekerForRegisterDto implements Dto {
    private String firstName;
    private String lastName;
    private String nationalIdentityNumber;
    private int birthYear;
    private String email;
    private String password;
}
