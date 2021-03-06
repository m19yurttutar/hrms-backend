package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.WorkExperience;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkExperienceDao extends JpaRepository<WorkExperience, Integer> {
    List<WorkExperience> getByCurriculumVitae_JobSeeker_Id(Integer jobSeekerId, Sort sort);
}
