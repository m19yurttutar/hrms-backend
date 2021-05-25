package kodlamaio.hrms.business.concretes;

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
        List<JobSeeker> jobSeekers = jobSeekerDao.findAll();

        for(JobSeeker jobSeeker : jobSeekers){
            if (jobSeeker.getNationalIdentity().equals(nationalIdentity)){
                return new SuccessDataResult<>(jobSeeker, Messages.jobSeekerListed);
            }
        }
        return new ErrorDataResult<>("Bu kimlik numarasına sahip hesap bulunamadı.");
    }

    @Override
    public Result add(JobSeeker jobSeeker) {
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
}
