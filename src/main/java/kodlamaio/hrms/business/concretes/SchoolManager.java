package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.SchoolService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.SchoolDao;
import kodlamaio.hrms.entities.concretes.CurriculumVitae;
import kodlamaio.hrms.entities.concretes.School;
import kodlamaio.hrms.entities.dtos.SchoolDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolManager implements SchoolService {

    private final SchoolDao schoolDao;

    @Autowired
    public SchoolManager(SchoolDao schoolDao) {
        this.schoolDao = schoolDao;
    }

    @Override
    public DataResult<List<School>> getAll() {
        return new SuccessDataResult<>(schoolDao.findAll());
    }

    @Override
    public DataResult<List<School>> getByCurriculumVitaeJobSeekerIdSortedByGraduationYear(Integer jobSeekerId) {
        Sort sort = Sort.by(Sort.Direction.DESC, "graduationYear");
        return new SuccessDataResult<>(schoolDao.getByCurriculumVitae_JobSeeker_Id(jobSeekerId, sort));
    }

    @Override
    public Result add(SchoolDto schoolDto) {
        School school = schoolDtoToWorkSchoolConverter(schoolDto);
        schoolDao.save(school);
        return new SuccessResult();
    }

    @Override
    public Result delete(School school) {
        schoolDao.delete(school);
        return new SuccessResult();
    }

    @Override
    public Result update(School school) {
        schoolDao.save(school);
        return new SuccessResult();
    }

    //This method converts the SchoolDto object into a form that the database will recognize.
    private School schoolDtoToWorkSchoolConverter(SchoolDto schoolDto){
        //This value will hold the curriculumVitaeId of the logged-in user when the JSON Web Token was written.
        int currentCurriculumVitaeId = 1;

        CurriculumVitae curriculumVitae = new CurriculumVitae(currentCurriculumVitaeId);

        return new School(curriculumVitae, schoolDto.getSchoolName(), schoolDto.getDepartmentName(), schoolDto.getStartYear(), schoolDto.getGraduationYear());
    }
}
