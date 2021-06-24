package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.LanguageService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.LanguageDao;
import kodlamaio.hrms.entities.concretes.CurriculumVitae;
import kodlamaio.hrms.entities.concretes.Language;
import kodlamaio.hrms.entities.dtos.LanguageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageManager implements LanguageService {

    private final LanguageDao languageDao;

    @Autowired
    public LanguageManager(LanguageDao languageDao) {
        this.languageDao = languageDao;
    }

    @Override
    public DataResult<List<Language>> getAll() {
        return new SuccessDataResult<>(languageDao.findAll(), Messages.languagesListed);
    }

    @Override
    public DataResult<List<Language>> getByJobSeekerIdSorted(Integer jobSeekerId) {
        return new SuccessDataResult<>(languageDao.getByCurriculumVitae_JobSeeker_Id(jobSeekerId), Messages.languagesListed);
    }

    @Override
    public Result add(LanguageDto languageDto) {
        Language language = languageDtoToLanguageConverter(languageDto);
        languageDao.save(language);
        return new SuccessResult(Messages.languageAdded);
    }

    @Override
    public Result delete(Language language) {
        languageDao.delete(language);
        return new SuccessResult(Messages.languageDeleted);
    }

    @Override
    public Result update(Language language) {
        languageDao.save(language);
        return new SuccessResult(Messages.languageUpdated);
    }

    //This method converts the LanguageDto object into a form that the database will recognize.
    private Language languageDtoToLanguageConverter(LanguageDto languageDto){
        //This value will hold the curriculumVitaeId of the logged-in user when the JSON Web Token was written.
        int currentCurriculumVitaeId = 1;

        CurriculumVitae curriculumVitae = new CurriculumVitae(currentCurriculumVitaeId);

        return new Language(curriculumVitae, languageDto.getLanguage(), languageDto.getLanguageLevel());
    }
}
