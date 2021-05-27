package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.AuthService;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.validationRules.Validator;
import kodlamaio.hrms.core.utilities.adapters.VerificationAdapter;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.validation.ValidationRules;
import kodlamaio.hrms.core.utilities.verification.VerificationRules;
import kodlamaio.hrms.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployerAuthManager implements AuthService<Employer> {

    private EmployerService employerService;

    @Autowired
    public EmployerAuthManager(EmployerService employerService) {
        this.employerService = employerService;
    }

    @Override
    public Result register(Employer employer, String confirmPassword) {

        Result validationResult = ValidationRules.run(
                Validator.AreFieldsFull(employer.getCompanyName(), employer.getWebsite(), employer.getPhoneNumber(), employer.getEmail(), employer.getPassword(), confirmPassword),
                Validator.IsEmailInEmailFormat(employer.getEmail()),
                Validator.DoesEmailHaveSameDomainAsWebsite(employer.getEmail(), employer.getWebsite()),
                Validator.IsPasswordSameAsConfirmPassword(employer.getPassword(), confirmPassword)
        );

        Result verificationResult = VerificationRules.run(VerificationAdapter.EmailVerification(), VerificationAdapter.SystemEmployeesVerification());

        if (validationResult != null) {
            return validationResult;
        } else if (verificationResult != null) {
            return verificationResult;
        }

        return this.employerService.add(employer);
    }

}
