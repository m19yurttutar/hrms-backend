package kodlamaio.hrms.entities.dtos;

import kodlamaio.hrms.core.entities.abstracts.Dto;
import lombok.Data;

import java.time.LocalDate;

@Data
public class JobSeekerDto implements Dto {
    private String firstName;
    private String lastName;
    private String nationalIdentityNumber;
    private LocalDate birthDate;
    private String email;
    private String password;
}
