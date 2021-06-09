package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.Gender;

import java.util.List;

public interface GenderService {
    DataResult<List<Gender>> getAll();
}
