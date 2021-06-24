package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.School;
import kodlamaio.hrms.entities.dtos.SchoolDto;

import java.util.List;

public interface SchoolService {
    DataResult<List<School>> getAll();
    DataResult<List<School>> getByJobSeekerIdSorted(Integer jobSeekerId);
    Result add(SchoolDto schoolDto);
    Result delete(School school);
    Result update(School school);
}
