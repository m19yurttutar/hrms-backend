package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.core.utilities.business.BusinessRules;
import kodlamaio.hrms.core.utilities.results.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.business.abstracts.JobPositionService;
import kodlamaio.hrms.dataAccess.abstracts.JobPositionDao;
import kodlamaio.hrms.entities.concretes.JobPosition;

import java.util.List;

@Service
public class JobPositionManager implements JobPositionService {

    private JobPositionDao jobPositionDao;

    @Autowired
    public JobPositionManager(JobPositionDao jobPositionDao) {
        this.jobPositionDao = jobPositionDao;
    }

    @Override
    public DataResult<List<JobPosition>> getAll() {
        return new SuccessDataResult<>(jobPositionDao.findAll(),Messages.jobPositionsListed);
    }

    @Override
    public Result add(JobPosition jobPosition) {

        Result businessResult = BusinessRules.run(CheckIfJobPositionExists(jobPosition.getJobPositionName()));

        if (businessResult != null){
            return businessResult;
        }

        jobPositionDao.save(jobPosition);
        return new SuccessResult(Messages.jobPositionAdded);
    }

    @Override
    public Result delete(JobPosition jobPosition) {
        jobPositionDao.delete(jobPosition);
        return new SuccessResult(Messages.jobPositionDeleted);
    }

    @Override
    public Result update(JobPosition jobPosition) {
        jobPositionDao.save(jobPosition);
        return new SuccessResult(Messages.jobPositionUpdated);
    }

    private Result CheckIfJobPositionExists(String jobPositionName){
        var result = jobPositionDao.getByJobPositionName(jobPositionName);

        if (result != null){
            return new ErrorResult("Bu pozisyon adı zaten bulunmaktadır.");
        }
        return new SuccessResult();
    }
}
