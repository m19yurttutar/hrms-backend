package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.business.validationRules.Validator;
import kodlamaio.hrms.core.utilities.business.BusinessRules;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.core.utilities.validation.ValidationRules;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.entities.concretes.*;
import kodlamaio.hrms.entities.dtos.JobAdvertisementDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

    private final JobAdvertisementDao jobAdvertisementDao;
    private final EmployerService employerService;

    @Autowired
    public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao, EmployerService employerService){
        this.jobAdvertisementDao = jobAdvertisementDao;
        this.employerService = employerService;
    }

    @Override
    public DataResult<List<JobAdvertisement>> getAll() {
        return new SuccessDataResult<>(this.jobAdvertisementDao.findAll(),Messages.jobAdvertisementsListed);
    }

    @Override
    public DataResult<List<JobAdvertisement>> getByActivityStatus() {
        return new SuccessDataResult<>(this.jobAdvertisementDao.getByActivityStatusTrue());
    }

    @Override
    public DataResult<List<JobAdvertisement>> getByActivityStatusSorted() {
        Sort sort = Sort.by(Sort.Direction.DESC, "releaseDate");
        return new SuccessDataResult<>(this.jobAdvertisementDao.getByActivityStatusTrue(sort));
    }

    @Override
    public DataResult<List<JobAdvertisement>> getByEmployer_IdAndActivityStatus(Integer employerId) {
        return new SuccessDataResult<>(this.jobAdvertisementDao.getByEmployer_IdAndActivityStatusTrue(employerId));
    }

    @Override
    public DataResult<JobAdvertisement> getById(Integer id) {
        return new SuccessDataResult<>(this.jobAdvertisementDao.getById(id), Messages.jobAdvertisementListed);
    }

    @Override
    public Result add(JobAdvertisementDto jobAdvertisementDto) {

        Result areFieldsFullResult = ValidationRules.run(
                Validator.AreFieldsFull(
                        jobAdvertisementDto.getJobPositionId(), jobAdvertisementDto.getCityId(), jobAdvertisementDto.getWorkingTypeId(),
                        jobAdvertisementDto.getWorkingTimeId(), jobAdvertisementDto.getJobSummary(), jobAdvertisementDto.getJobDescription(),
                        jobAdvertisementDto.getVacantPositionCount(), jobAdvertisementDto.getApplicationDeadline()));

        if (areFieldsFullResult != null){
            return areFieldsFullResult;
        }

        Result validationResult = ValidationRules.run(Validator.IsApplicationDeadlineInApplicationDeadlineFormat(jobAdvertisementDto.getApplicationDeadline()));

        if (validationResult != null){
            return validationResult;
        }

        JobAdvertisement jobAdvertisement= jobAdvertisementDtoToJobAdvertisementConverter(jobAdvertisementDto);

        Result businessResult = BusinessRules.run(IsUserRoleEmployer(jobAdvertisement.getEmployer().getId()));

        if (businessResult != null){
            return businessResult;
        }

        this.jobAdvertisementDao.save(jobAdvertisement);
        return new SuccessResult(Messages.jobAdvertisementAdded);
    }

    @Override
    public Result delete(JobAdvertisement jobAdvertisement) {
        this.jobAdvertisementDao.delete(jobAdvertisement);
        return new SuccessResult(Messages.jobAdvertisementDeleted);
    }

    @Override
    public Result update(JobAdvertisement jobAdvertisement) {
        this.jobAdvertisementDao.save(jobAdvertisement);
        return new SuccessResult(Messages.jobAdvertisementUpdated);
    }

    private Result IsUserRoleEmployer(Integer id){
        var employer = employerService.getById(id).getData();

        if (employer == null){
            return new  ErrorResult("Bu işlem için uygun role sahip değilsiniz.");
        }
        return new SuccessResult();
    }

    //This method converts the JobAdvertisementDtoDto object into a form that the database will recognize.
    private JobAdvertisement jobAdvertisementDtoToJobAdvertisementConverter(JobAdvertisementDto jobAdvertisementDto){
        //This value will hold the userId of the logged-in user when the JSON Web Token was written.
        int currentUserId = 5;

        Employer employer = new Employer(currentUserId);

        return new JobAdvertisement(
                employer, new JobPosition(jobAdvertisementDto.getJobPositionId()), new City(jobAdvertisementDto.getCityId()), new WorkingType(jobAdvertisementDto.getWorkingTypeId()), new WorkingTime(jobAdvertisementDto.getWorkingTimeId()), jobAdvertisementDto.getJobSummary(), jobAdvertisementDto.getJobDescription(),
                jobAdvertisementDto.getMinSalary(), jobAdvertisementDto.getMaxSalary(), jobAdvertisementDto.getVacantPositionCount(), LocalDate.parse(jobAdvertisementDto.getApplicationDeadline()));
    }
}
