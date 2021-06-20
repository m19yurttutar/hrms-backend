package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.GenderService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.GenderDao;
import kodlamaio.hrms.entities.concretes.Gender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenderManager implements GenderService {

    private final GenderDao genderDao;

    @Autowired
    public GenderManager(GenderDao genderDao){
        this.genderDao = genderDao;
    }

    @Override
    public DataResult<List<Gender>> getAll() {
        return new SuccessDataResult<>(genderDao.findAll(), Messages.gendersListed);
    }
}
