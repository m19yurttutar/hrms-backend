package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.AuthService;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.business.validationRules.AuthValidator;
import kodlamaio.hrms.core.utilities.business.BusinessRules;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.core.utilities.validation.ValidationRules;
import kodlamaio.hrms.entities.DTOs.EmployerForRegisterDto;
import kodlamaio.hrms.entities.DTOs.JobSeekerForRegisterDto;
import kodlamaio.hrms.entities.DTOs.UserForLoginDto;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import kodlamaio.hrms.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployerAuthManager implements AuthService<EmployerForRegisterDto> {

    private UserService userService;
    private EmployerService employerService;

    @Autowired
    public EmployerAuthManager(UserService userService, EmployerService employerService){
        this.userService = userService;
        this.employerService = employerService;
    }

    @Override
    public Result register(EmployerForRegisterDto registerDto, String confirmPassword) {

        Result validationResult = ValidationRules.run(AuthValidator.AreFieldsFull(
                registerDto.getCompanyName(),
                registerDto.getWebsite(),
                registerDto.getPhoneNumber(),
                registerDto.getEmail(),
                registerDto.getPassword(),
                confirmPassword),
                AuthValidator.IsPasswordSameAsConfirmPassword(registerDto.getPassword(), confirmPassword),
                AuthValidator.DoesEmailHaveSameDomainAsWebsite(registerDto.getEmail(),registerDto.getWebsite()));

        if (validationResult != null){
            return validationResult;
        }else{
            User user = new User(registerDto.getEmail(),registerDto.getPassword());
            userService.add(user);

            int newUserId = userService.getByEmail(registerDto.getEmail()).getData().getId();
            Employer employer = new Employer(newUserId, registerDto.getCompanyName(), registerDto.getWebsite(), registerDto.getPhoneNumber());
            employerService.add(employer);

            return new SuccessResult();
        }

    }

    @Override
    public Result login(UserForLoginDto userForLoginDto) {
        return null;
    }


}
