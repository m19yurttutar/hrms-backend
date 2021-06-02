package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.WorkExperience;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkExperienceDao extends JpaRepository<WorkExperience, Integer> {
}
