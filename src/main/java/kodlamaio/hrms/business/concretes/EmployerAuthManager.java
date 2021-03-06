package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.AuthService;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.validationRules.Validator;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.validation.ValidationRules;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.ProfilePhoto;
import kodlamaio.hrms.entities.dtos.EmployerDto;

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
    public Result register(EmployerDto employerDto) {

        Result areFieldsFullResult = ValidationRules.run(Validator.AreFieldsFull(employerDto.getCompanyName(), employerDto.getWebsite(), employerDto.getPhoneNumber(), employerDto.getEmail(), employerDto.getPassword(), employerDto.getConfirmPassword()));

        if (areFieldsFullResult != null) {
            return areFieldsFullResult;
        }

        Result validationResult = ValidationRules.run(
                Validator.IsEmailInEmailFormat(employerDto.getEmail()),
                Validator.IsWebsiteInWebsiteFormat(employerDto.getWebsite()),
                Validator.IsPhoneNumberInPhoneNumberFormat(employerDto.getPhoneNumber()),
                Validator.DoesEmailHaveSameDomainAsWebsite(employerDto.getEmail(), employerDto.getWebsite()),
                Validator.IsPasswordSameAsConfirmPassword(employerDto.getPassword(), employerDto.getConfirmPassword())
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
