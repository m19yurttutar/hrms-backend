package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.adapters.VerificationAdapter;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerManager implements EmployerService {

    private EmployerDao employerDao;

    @Autowired
    public EmployerManager(EmployerDao employerDao){
        this.employerDao = employerDao;
    }

    @Override
    public DataResult<List<Employer>> getAll() {
        return new SuccessDataResult(employerDao.findAll(), Messages.employersListed);
    }

    @Override
    public Result add(Employer employer) {
        Result emailVerificationResult = VerificationAdapter.EmailVerification();
        Result systemEmployeesVerificationResult = VerificationAdapter.SystemEmployeesVerification();

        if (!emailVerificationResult.isSuccess()){
            return emailVerificationResult;
        }else if(!systemEmployeesVerificationResult.isSuccess()) {
            return systemEmployeesVerificationResult;
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

}
