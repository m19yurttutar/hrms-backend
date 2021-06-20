package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.SystemEmployeeService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.SystemEmployeeDao;
import kodlamaio.hrms.entities.concretes.*;
import kodlamaio.hrms.entities.dtos.SystemEmployeeDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemEmployeeManager implements SystemEmployeeService {

    private final SystemEmployeeDao systemEmployeeDao;

    @Autowired
    public SystemEmployeeManager(SystemEmployeeDao systemEmployeeDao) {
        this.systemEmployeeDao = systemEmployeeDao;
    }

    @Override
    public DataResult<List<SystemEmployee>> getAll() {
        return new SuccessDataResult<>(systemEmployeeDao.findAll(), Messages.systemEmployeesListed);
    }

    @Override
    public Result add(SystemEmployeeDto systemEmployeeDto) {

        SystemEmployee systemEmployee = systemEmployeeDtoToSystemEmployeeConverter(systemEmployeeDto);

        systemEmployeeDao.save(systemEmployee);
        return new SuccessResult(Messages.systemEmployeeAdded);
    }

    @Override
    public Result delete(SystemEmployee systemEmployee) {
        systemEmployeeDao.delete(systemEmployee);
        return new SuccessResult(Messages.systemEmployeeDeleted);
    }

    @Override
    public Result update(SystemEmployee systemEmployee) {
        systemEmployeeDao.save(systemEmployee);
        return new SuccessResult(Messages.systemEmployeeUpdated);
    }

    //This method converts the SystemEmployeeDto object into a form that the database will recognize.
    private SystemEmployee systemEmployeeDtoToSystemEmployeeConverter(SystemEmployeeDto systemEmployeeDto){
        return new SystemEmployee(new ProfilePhoto(), systemEmployeeDto.getEmail(), systemEmployeeDto.getPassword(), new JobPosition(systemEmployeeDto.getJobPositionId()), systemEmployeeDto.getFirstName(), systemEmployeeDto.getLastName());
    }
}
