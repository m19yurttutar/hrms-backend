package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.AuthService;
import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.business.validationRules.Validator;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.validation.ValidationRules;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobSeekerAuthManager implements AuthService<JobSeeker> {

    private final JobSeekerService jobSeekerService;

    @Autowired
    public JobSeekerAuthManager(JobSeekerService jobSeekerService){
        this.jobSeekerService = jobSeekerService;
    }

    @Override
    public Result register(JobSeeker jobSeeker, String confirmPassword) {

        Result validationResult = ValidationRules.run(
                Validator.AreFieldsFull(jobSeeker.getFirstName(), jobSeeker.getLastName(), jobSeeker.getNationalIdentityNumber(), jobSeeker.getBirthDate(), jobSeeker.getEmail(), jobSeeker.getPassword(), confirmPassword),
                Validator.IsEmailInEmailFormat(jobSeeker.getEmail()),
                Validator.IsBirthDateInBirthDateFormat(jobSeeker.getBirthDate()),
                Validator.IsPasswordSameAsConfirmPassword(jobSeeker.getPassword(),confirmPassword));

        if (validationResult != null){
            return validationResult;
        }

        return this.jobSeekerService.add(jobSeeker);
    }
}
