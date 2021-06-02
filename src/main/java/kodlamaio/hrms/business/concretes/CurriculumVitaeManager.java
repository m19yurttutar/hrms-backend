package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.CurriculumVitaeService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CurriculumVitaeDao;
import kodlamaio.hrms.entities.concretes.CurriculumVitae;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurriculumVitaeManager implements CurriculumVitaeService {

    private final CurriculumVitaeDao curriculumVitaeDao;

    public CurriculumVitaeManager(CurriculumVitaeDao curriculumVitaeDao) {
        this.curriculumVitaeDao = curriculumVitaeDao;
    }

    @Override
    public DataResult<List<CurriculumVitae>> getAll() {
        return new SuccessDataResult<>(curriculumVitaeDao.findAll(), Messages.curriculumVitaesListed);
    }

    @Override
    public DataResult<CurriculumVitae> getByJobSeekerId(Integer jobSeekerId) {
        return new SuccessDataResult<>(curriculumVitaeDao.getByJobSeeker_Id(jobSeekerId), Messages.curriculumVitaeListed);
    }

    @Override
    public Result add(CurriculumVitae curriculumVitae) {
        curriculumVitaeDao.save(curriculumVitae);
        return new SuccessResult(Messages.curriculumVitaeAdded);
    }

    @Override
    public Result delete(CurriculumVitae curriculumVitae) {
        curriculumVitaeDao.delete(curriculumVitae);
        return new SuccessResult(Messages.curriculumVitaeDeleted);
    }

    @Override
    public Result update(CurriculumVitae curriculumVitae) {
        curriculumVitaeDao.save(curriculumVitae);
        return new SuccessResult(Messages.curriculumVitaeUpdated);
    }
}
