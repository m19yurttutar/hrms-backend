package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CurriculumVitae;

import java.util.List;

public interface CurriculumVitaeService {
    DataResult<List<CurriculumVitae>> getAll();
    DataResult<CurriculumVitae> getByJobSeekerId(Integer jobSeekerId);
    Result add(CurriculumVitae curriculumVitae);
    Result delete(CurriculumVitae curriculumVitae);
    Result update(CurriculumVitae curriculumVitae);
}
