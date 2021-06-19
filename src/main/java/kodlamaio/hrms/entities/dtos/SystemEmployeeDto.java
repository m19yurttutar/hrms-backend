package kodlamaio.hrms.entities.dtos;

import kodlamaio.hrms.core.entities.abstracts.Dto;
import lombok.Data;

@Data
public class SystemEmployeeDto implements Dto {
    private int jobPositionId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String confirmPassword;
}
