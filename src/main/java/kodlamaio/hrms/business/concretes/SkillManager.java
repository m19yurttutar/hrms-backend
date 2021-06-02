package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.SkillService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.SkillDao;
import kodlamaio.hrms.entities.concretes.CurriculumVitae;
import kodlamaio.hrms.entities.concretes.Skill;
import kodlamaio.hrms.entities.dtos.SkillDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillManager implements SkillService {

    private final SkillDao skillDao;

    @Autowired
    public SkillManager(SkillDao skillDao) {
        this.skillDao = skillDao;
    }

    @Override
    public DataResult<List<Skill>> getAll() {
        return new SuccessDataResult<>(skillDao.findAll());
    }

    @Override
    public Result add(SkillDto skillDto) {
        Skill skill = skillDtoToSkillConverter(skillDto);
        skillDao.save(skill);
        return new SuccessResult();
    }

    @Override
    public Result delete(Skill skill) {
        skillDao.delete(skill);
        return new SuccessResult();
    }

    @Override
    public Result update(Skill skill) {
        skillDao.save(skill);
        return new SuccessResult();
    }

    //This method converts the SkillDto object into a form that the database will recognize.
    private Skill skillDtoToSkillConverter(SkillDto skillDto){
        //This value will hold the curriculumVitaeId of the logged-in user when the JSON Web Token was written.
        int currentCurriculumVitaeId = 1;

        CurriculumVitae curriculumVitae = new CurriculumVitae(currentCurriculumVitaeId);

        return new Skill(curriculumVitae, skillDto.getProgrammingTechnologyName());
    }
}
