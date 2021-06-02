package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.WorkExperience;
import kodlamaio.hrms.entities.dtos.WorkExperienceDto;

import java.util.List;

public interface WorkExperienceService {
    DataResult<List<WorkExperience>> getAll();
    Result add(WorkExperienceDto workExperienceDto);
    Result delete(WorkExperience workExperience);
    Result update(WorkExperience workExperience);
}
