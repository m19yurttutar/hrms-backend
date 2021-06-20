package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.JobAdvertisementConfirmationService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementConfirmationDao;
import kodlamaio.hrms.entities.concretes.*;
import kodlamaio.hrms.entities.dtos.JobAdvertisementConfirmationDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class JobAdvertisementConfirmationManager implements JobAdvertisementConfirmationService {

    private final JobAdvertisementConfirmationDao jobAdvertisementConfirmationDao;

    @Autowired
    public JobAdvertisementConfirmationManager(JobAdvertisementConfirmationDao jobAdvertisementConfirmationDao) {
        this.jobAdvertisementConfirmationDao = jobAdvertisementConfirmationDao;
    }

    @Override
    public DataResult<List<JobAdvertisementConfirmation>> getAll() {
        return new SuccessDataResult<>(jobAdvertisementConfirmationDao.findAll(), Messages.jobAdvertisementConfirmationsListed);
    }

    @Override
    public Result update(JobAdvertisementConfirmationDto jobAdvertisementConfirmationDto) {

        JobAdvertisementConfirmation jobAdvertisementConfirmation = jobAdvertisementConfirmationDtoToJobAdvertisementConfirmationConverter(jobAdvertisementConfirmationDto);

        jobAdvertisementConfirmationDao.save(jobAdvertisementConfirmation);
        return new SuccessResult(Messages.jobAdvertisementConfirmationUpdated);
    }

    //This method converts the JobAdvertisementConfirmationDto object into a form that the database will recognize.
    private JobAdvertisementConfirmation jobAdvertisementConfirmationDtoToJobAdvertisementConfirmationConverter(JobAdvertisementConfirmationDto jobAdvertisementConfirmationDto){

        int currentUserId = 4;

        return new JobAdvertisementConfirmation(jobAdvertisementConfirmationDto.getJobAdvertisementId(), new SystemEmployee(currentUserId), jobAdvertisementConfirmationDto.isConfirmationStatus(), LocalDate.now());
    }
}
