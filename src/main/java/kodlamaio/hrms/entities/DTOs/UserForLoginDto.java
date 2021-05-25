package kodlamaio.hrms.entities.DTOs;

import kodlamaio.hrms.entities.abstracts.Dto;
import lombok.Data;

@Data
public class UserForLoginDto implements Dto {
    private String email;
    private String password;
}
