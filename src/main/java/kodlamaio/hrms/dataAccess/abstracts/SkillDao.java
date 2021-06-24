package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SkillDao extends JpaRepository<Skill, Integer> {
    List<Skill> getByCurriculumVitae_JobSeeker_Id(int jobSeekerId);
}
