package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.AuthService;
import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.business.validationRules.Validator;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.validation.ValidationRules;
import kodlamaio.hrms.entities.concretes.Connection;
import kodlamaio.hrms.entities.concretes.CurriculumVitae;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import kodlamaio.hrms.entities.concretes.ProfilePhoto;
import kodlamaio.hrms.entities.dtos.JobSeekerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobSeekerAuthManager implements AuthService<JobSeekerDto> {

    private final JobSeekerService jobSeekerService;

    @Autowired
    public JobSeekerAuthManager(JobSeekerService jobSeekerService){
        this.jobSeekerService = jobSeekerService;
    }

    @Override
    public Result register(JobSeekerDto jobSeekerDto, String confirmPassword) {

        Result validationResult = ValidationRules.run(
                Validator.AreFieldsFull(jobSeekerDto.getFirstName(), jobSeekerDto.getLastName(), jobSeekerDto.getNationalIdentityNumber(), jobSeekerDto.getBirthDate(), jobSeekerDto.getEmail(), jobSeekerDto.getPassword(), confirmPassword),
                Validator.IsEmailInEmailFormat(jobSeekerDto.getEmail()),
                Validator.IsBirthDateInBirthDateFormat(jobSeekerDto.getBirthDate()),
                Validator.IsPasswordSameAsConfirmPassword(jobSeekerDto.getPassword(),confirmPassword));

        if (validationResult != null){
            return validationResult;
        }
        JobSeeker jobSeeker = jobSeekerDtoToProfilePhotoConverter(jobSeekerDto);

        return this.jobSeekerService.add(jobSeeker);
    }

    //This method converts the JobSeekerDto object into a form that the database will recognize.
    private JobSeeker jobSeekerDtoToProfilePhotoConverter(JobSeekerDto jobSeekerDto){

        CurriculumVitae curriculumVitae = new CurriculumVitae(new ProfilePhoto(), new Connection());

        return new JobSeeker(jobSeekerDto.getEmail(), jobSeekerDto.getPassword(), jobSeekerDto.getNationalIdentityNumber(), jobSeekerDto.getFirstName(), jobSeekerDto.getLastName(), jobSeekerDto.getBirthDate(), curriculumVitae);
    }
}
