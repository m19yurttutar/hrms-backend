package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Skill;
import kodlamaio.hrms.entities.dtos.SkillDto;

import java.util.List;

public interface SkillService {
    DataResult<List<Skill>> getAll();
    DataResult<List<Skill>> getByJobSeekerId(Integer jobSeekerId);
    Result add(SkillDto skillDto);
    Result delete(Skill skill);
    Result update(Skill skill);
}
