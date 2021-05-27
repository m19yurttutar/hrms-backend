package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.AuthService;
import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.business.validationRules.Validator;
import kodlamaio.hrms.core.utilities.adapters.VerificationAdapter;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.validation.ValidationRules;
import kodlamaio.hrms.core.utilities.verification.VerificationRules;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class JobSeekerAuthManager implements AuthService<JobSeeker> {

    private JobSeekerService jobSeekerService;

    @Autowired
    public JobSeekerAuthManager(JobSeekerService jobSeekerService){
        this.jobSeekerService = jobSeekerService;
    }

    @Override
    public Result register(JobSeeker jobSeeker, String confirmPassword) {

        Result validationResult = ValidationRules.run(
                Validator.AreFieldsFull(jobSeeker.getFirstName(), jobSeeker.getLastName(), jobSeeker.getNationalIdentityNumber(), jobSeeker.getBirthDate(), jobSeeker.getEmail(), jobSeeker.getPassword(), confirmPassword),
                Validator.IsEmailInEmailFormat(jobSeeker.getEmail()),
                Validator.IsPasswordSameAsConfirmPassword(jobSeeker.getPassword(),confirmPassword));

        if (validationResult != null){
            return validationResult;
        }

        Result verificationResult = VerificationRules.run(VerificationAdapter.MernisVerification(jobSeeker.getNationalIdentityNumber()), VerificationAdapter.EmailVerification());

        if (verificationResult != null){
            return verificationResult;
        }

        return this.jobSeekerService.add(jobSeeker);
    }
}
