package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.validationRules.JobSeekerAuthValidator;
import kodlamaio.hrms.core.utilities.adapters.MernisAdapter;
import kodlamaio.hrms.core.utilities.validation.ValidationRules;
import kodlamaio.hrms.entities.DTOs.UserForLoginDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.utilities.business.BusinessRules;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.business.abstracts.AuthService;
import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.DTOs.JobSeekerForRegisterDto;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import kodlamaio.hrms.entities.concretes.User;

@Service
public class JobSeekerAuthManager implements AuthService<JobSeekerForRegisterDto> {


    private UserService userService;
    private JobSeekerService jobSeekerService;

    @Autowired
    public JobSeekerAuthManager(UserService userService, JobSeekerService jobSeekerService) {
        this.userService = userService;
        this.jobSeekerService = jobSeekerService;
    }

    @Override
    public Result register(JobSeekerForRegisterDto registerDto, String confirmPassword) {
        Result validationResult = ValidationRules.run(JobSeekerAuthValidator.AreFieldsFull(
                registerDto.getBirthYear(),
                registerDto.getFirstName(),
                registerDto.getLastName(),
                registerDto.getNationalIdentityNumber(),
                registerDto.getEmail(),
                registerDto.getPassword(),
                confirmPassword
        ));
        Result mernisResult = MernisAdapter.CheckIfRealPerson(registerDto.getNationalIdentityNumber());
        Result businessResult = BusinessRules.run(CheckIfEmailExists(registerDto.getEmail()), CheckIfNationalIdentityExists(registerDto.getNationalIdentityNumber()));

        if (validationResult != null) {
            return validationResult;
        } else if(mernisResult != null){
            return mernisResult;
        }else if (businessResult != null) {
            return businessResult;
        } else {
            User user = new User();
            user.setEmail(registerDto.getEmail());
            user.setPassword(registerDto.getPassword());
            userService.add(user);
            int newUserId = userService.getByEmail(registerDto.getEmail()).getData().getId();
            JobSeeker jobSeeker = new JobSeeker(newUserId, registerDto.getNationalIdentityNumber(), registerDto.getFirstName(), registerDto.getLastName(), registerDto.getBirthYear());
            jobSeekerService.add(jobSeeker);
            return new SuccessResult();
        }
    }

    @Override
    public Result login(UserForLoginDto userForLoginDto) {
        return null;
    }

    private Result CheckIfEmailExists(String email) {
        var result = userService.getByEmail(email).getData();

        if (result == null) {
            return new SuccessResult();
        }
        return new ErrorResult("Bu email adresi daha önce kullanılmış.");
    }

    private Result CheckIfNationalIdentityExists(String nationalIdentity) {
        var result = jobSeekerService.getByNationalIdentity(nationalIdentity).getData();

        if (result == null) {
            return new SuccessResult();
        }
        return new ErrorResult("Bu kimlik numarası daha önce kullanılmış.");
    }
}
