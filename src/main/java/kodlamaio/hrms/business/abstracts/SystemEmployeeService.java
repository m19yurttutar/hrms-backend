package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.SystemEmployee;
import kodlamaio.hrms.entities.dtos.SystemEmployeeDto;

import java.util.List;

public interface SystemEmployeeService {
        DataResult<List<SystemEmployee>> getAll();
        Result add(SystemEmployeeDto systemEmployeeDto);
        Result delete(SystemEmployee systemEmployee);
        Result update(SystemEmployee systemEmployee);
}
