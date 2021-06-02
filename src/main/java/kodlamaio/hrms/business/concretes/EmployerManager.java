package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.adapters.VerificationAdapter;
import kodlamaio.hrms.core.utilities.business.BusinessRules;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.core.utilities.verification.VerificationRules;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerManager implements EmployerService {

    private final EmployerDao employerDao;

    @Autowired
    public EmployerManager(EmployerDao employerDao){
        this.employerDao = employerDao;
    }

    @Override
    public DataResult<List<Employer>> getAll() {
        return new SuccessDataResult<>(employerDao.findAll(), Messages.employersListed);
    }

    @Override
    public DataResult<Employer> getById(Integer id) {
        return new SuccessDataResult<>(employerDao.getById(id),Messages.employerListed);
    }

    @Override
    public Result add(Employer employer) {

        Result businessResult = BusinessRules.run(CheckIfEmailExists(employer.getEmail()));

        if(businessResult != null){
            return businessResult;
        }

        Result verificationResult = VerificationRules.run(VerificationAdapter.EmailVerification(), VerificationAdapter.SystemEmployeesVerification());

        if (verificationResult != null) {
            return verificationResult;
        }

        employerDao.save(employer);
        return new SuccessResult(Messages.employerAdded);
    }

    @Override
    public Result delete(Employer employer) {
        employerDao.delete(employer);
        return new SuccessResult(Messages.employerDeleted);
    }

    @Override
    public Result update(Employer employer) {
        employerDao.save(employer);
        return new SuccessResult(Messages.employerUpdated);
    }

    private Result CheckIfEmailExists(String email) {
        var result = employerDao.getByEmail(email);

        if (result != null) {
            return new ErrorResult("Bu email adresi daha önce kullanılmış.");
        }
        return new SuccessResult();
    }
}
