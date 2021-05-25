package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.AuthService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.DTOs.EmployerForRegisterDto;
import kodlamaio.hrms.entities.DTOs.JobSeekerForRegisterDto;
import kodlamaio.hrms.entities.DTOs.UserForLoginDto;

public class EmployerAuthManager implements AuthService<EmployerForRegisterDto> {
    @Override
    public Result register(EmployerForRegisterDto registerDto, String confirmPassword) {
        return null;
    }

    @Override
    public Result login(UserForLoginDto userForLoginDto) {
        return null;
    }
}
