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

import java.time.LocalDate;

@Service
public class JobSeekerAuthManager implements AuthService<JobSeekerDto> {

    private final JobSeekerService jobSeekerService;

    @Autowired
    public JobSeekerAuthManager(JobSeekerService jobSeekerService){
        this.jobSeekerService = jobSeekerService;
    }

    @Override
    public Result register(JobSeekerDto jobSeekerDto) {

        Result validationResult = ValidationRules.run(
                Validator.AreFieldsFull(jobSeekerDto.getFirstName(), jobSeekerDto.getLastName(), jobSeekerDto.getNationalIdentityNumber(), jobSeekerDto.getBirthDate(), jobSeekerDto.getEmail(), jobSeekerDto.getPassword(), jobSeekerDto.getConfirmPassword()),
                Validator.IsEmailInEmailFormat(jobSeekerDto.getEmail()),
                Validator.IsBirthDateInBirthDateFormat(jobSeekerDto.getBirthDate()),
                Validator.IsPasswordSameAsConfirmPassword(jobSeekerDto.getPassword(), jobSeekerDto.getConfirmPassword()));

        if (validationResult != null){
            return validationResult;
        }
        JobSeeker jobSeeker = jobSeekerDtoToJobSeekerConverter(jobSeekerDto);

        return this.jobSeekerService.add(jobSeeker);
    }

    //This method converts the JobSeekerDto object into a form that the database will recognize.
    private JobSeeker jobSeekerDtoToJobSeekerConverter(JobSeekerDto jobSeekerDto){

        ProfilePhoto profilePhoto = new ProfilePhoto();
        CurriculumVitae curriculumVitae = new CurriculumVitae(new Connection());

        return new JobSeeker(profilePhoto, jobSeekerDto.getEmail(), jobSeekerDto.getPassword(), curriculumVitae, jobSeekerDto.getGender(), jobSeekerDto.getFirstName(), jobSeekerDto.getLastName(), jobSeekerDto.getNationalIdentityNumber(), LocalDate.parse(jobSeekerDto.getBirthDate()));
    }
}
