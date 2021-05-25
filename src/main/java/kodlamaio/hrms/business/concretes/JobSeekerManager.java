package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.core.utilities.adapters.VerificationAdapter;
import kodlamaio.hrms.core.utilities.business.BusinessRules;
import kodlamaio.hrms.core.utilities.results.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerDao;
import kodlamaio.hrms.entities.concretes.JobSeeker;

import java.util.List;

@Service
public class JobSeekerManager implements JobSeekerService {

    private JobSeekerDao jobSeekerDao;

    @Autowired
    public JobSeekerManager(JobSeekerDao jobSeekerDao){
        this.jobSeekerDao = jobSeekerDao;
    }

    @Override
    public DataResult<List<JobSeeker>> getAll() {
        return new SuccessDataResult<>(jobSeekerDao.findAll(),Messages.jobSeekersListed);
    }

    @Override
    public DataResult<JobSeeker> getByNationalIdentity(String nationalIdentity) {
        return new SuccessDataResult<>(jobSeekerDao.getByNationalIdentity(nationalIdentity), Messages.jobSeekerListed);
    }

    @Override
    public Result add(JobSeeker jobSeeker) {

        Result businessResult = BusinessRules.run(CheckIfNationalIdentityExists(jobSeeker.getNationalIdentity()));
        Result emailVerificationResult = VerificationAdapter.EmailVerification();

        if (businessResult != null){
            return businessResult;
        }else if(!emailVerificationResult.isSuccess()){
            return emailVerificationResult;
        }

        jobSeekerDao.save(jobSeeker);
        return new SuccessResult(Messages.jobSeekerAdded);
    }

    @Override
    public Result delete(JobSeeker jobSeeker) {
        jobSeekerDao.delete(jobSeeker);
        return new SuccessResult(Messages.jobSeekerDeleted);
    }

    @Override
    public Result update(JobSeeker jobSeeker) {
        jobSeekerDao.save(jobSeeker);
        return new SuccessResult(Messages.jobSeekerUpdated);
    }

    private Result CheckIfNationalIdentityExists(String nationalIdentity) {
        var result = getByNationalIdentity(nationalIdentity).getData();

        if (result == null) {
            return new SuccessResult();
        }
        return new ErrorResult("Bu kimlik numarası daha önce kullanılmış.");
    }
}
