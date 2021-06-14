package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.WorkingTypeService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.WorkingTypeDao;
import kodlamaio.hrms.entities.concretes.WorkingType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkingTypeManager implements WorkingTypeService {

    private final WorkingTypeDao workingTypeDao;

    @Autowired
    public WorkingTypeManager(WorkingTypeDao workingTypeDao) {
        this.workingTypeDao = workingTypeDao;
    }

    @Override
    public DataResult<List<WorkingType>> getAll() {
        return new SuccessDataResult<>(this.workingTypeDao.findAll(), Messages.workingTypesListed);
    }
}
