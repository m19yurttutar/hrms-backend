package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.WorkingType;

import java.util.List;

public interface WorkingTypeService {
    DataResult<List<WorkingType>> getAll();
}
