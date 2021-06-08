package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.AuthService;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.validationRules.Validator;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.validation.ValidationRules;
import kodlamaio.hrms.entities.concretes.*;
import kodlamaio.hrms.entities.dtos.EmployerDto;
import kodlamaio.hrms.entities.dtos.JobSeekerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployerAuthManager implements AuthService<EmployerDto> {

    private final EmployerService employerService;

    @Autowired
    public EmployerAuthManager(EmployerService employerService) {
        this.employerService = employerService;
    }

    @Override
    public Result register(EmployerDto employerDto, String confirmPassword) {

        Result validationResult = ValidationRules.run(
                Validator.AreFieldsFull(employerDto.getCompanyName(), employerDto.getWebsite(), employerDto.getPhoneNumber(), employerDto.getEmail(), employerDto.getPassword(), confirmPassword),
                Validator.IsEmailInEmailFormat(employerDto.getEmail()),
                Validator.IsPhoneNumberInPhoneNumberFormat(employerDto.getPhoneNumber()),
                Validator.DoesEmailHaveSameDomainAsWebsite(employerDto.getEmail(), employerDto.getWebsite()),
                Validator.IsPasswordSameAsConfirmPassword(employerDto.getPassword(), confirmPassword)
        );

        if (validationResult != null) {
            return validationResult;
        }

        Employer employer = employerDtoToEmployerConverter(employerDto);

        return this.employerService.add(employer);
    }

    //This method converts the JobSeekerDto object into a form that the database will recognize.
    private Employer employerDtoToEmployerConverter(EmployerDto employerDto){

        ProfilePhoto profilePhoto = new ProfilePhoto();

        return new Employer(profilePhoto, employerDto.getEmail(), employerDto.getPassword(), employerDto.getCompanyName(), employerDto.getWebsite(), employerDto.getPhoneNumber());
    }
}
