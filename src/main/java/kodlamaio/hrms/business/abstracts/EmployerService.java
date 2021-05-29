package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employer;

import java.util.List;

public interface EmployerService {
    DataResult<List<Employer>> getAll();
    DataResult<Employer> getById(Integer id);
    Result add(Employer employer);
    Result delete(Employer employer);
    Result update(Employer employer);
}
