package kodlamaio.hrms.entities.dtos;

import kodlamaio.hrms.core.entities.abstracts.Dto;
import lombok.Data;

@Data
public class EmployerDto implements Dto {
    private String companyName;
    private String website;
    private String phoneNumber;
    private String email;
    private String password;
}
