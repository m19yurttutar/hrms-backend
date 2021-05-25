package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.DTOs.UserForLoginDto;

public interface AuthService<TDto> {
    Result register(TDto registerDto, String confirmPassword);
    Result login(UserForLoginDto userForLoginDto);
}
