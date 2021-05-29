package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.DTOs.JobAdvertisementDto;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

import java.util.List;

public interface JobAdvertisementService {
    DataResult<List<JobAdvertisement>> getAll();
    DataResult<List<JobAdvertisement>> getByActivityStatus();
    DataResult<List<JobAdvertisement>> getByActivityStatusSorted();
    DataResult<List<JobAdvertisement>> getByEmployer_IdAndActivityStatus(Integer employerId);
    Result add(JobAdvertisementDto jobAdvertisementDto);
    Result delete(JobAdvertisement jobAdvertisement);
    Result update(JobAdvertisement jobAdvertisement);
}