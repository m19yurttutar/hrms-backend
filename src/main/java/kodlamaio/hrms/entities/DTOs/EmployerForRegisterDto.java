package kodlamaio.hrms.entities.DTOs;

import kodlamaio.hrms.entities.abstracts.Dto;
import lombok.Data;

@Data
public class EmployerForRegisterDto implements Dto {
    private String companyName;
    private String website;
    private String phoneNumber;
    private String email;
    private String password;
}
