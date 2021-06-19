package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisementConfirmation;
import kodlamaio.hrms.entities.dtos.JobAdvertisementConfirmationDto;

import java.util.List;

public interface JobAdvertisementConfirmationService {
    DataResult<List<JobAdvertisementConfirmation>> getAll();
    Result update(JobAdvertisementConfirmationDto jobAdvertisementConfirmationDto);
}
