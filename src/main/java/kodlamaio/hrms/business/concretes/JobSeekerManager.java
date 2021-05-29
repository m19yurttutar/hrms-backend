package kodlamaio.hrms.business.concretes;

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
    public Result add(JobSeeker jobSeeker) {

        Result businessResult = BusinessRules.run(CheckIfNationalIdentityExists(jobSeeker.getNationalIdentityNumber()),CheckIfEmailExists(jobSeeker.getEmail()));

        if (businessResult != null){
            return businessResult;
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

    private Result CheckIfNationalIdentityExists(String nationalIdentityNumber) {
        var result = jobSeekerDao.getByNationalIdentityNumber(nationalIdentityNumber);

        if (result != null) {
            return new ErrorResult("Bu kimlik numarası daha önce kullanılmış.");
        }
        return new SuccessResult();
    }

    private Result CheckIfEmailExists(String email) {
        var result = jobSeekerDao.getByEmail(email);

        if (result != null) {
            return new ErrorResult("Bu email adresi daha önce kullanılmış.");
        }
        return new SuccessResult();
    }
}
