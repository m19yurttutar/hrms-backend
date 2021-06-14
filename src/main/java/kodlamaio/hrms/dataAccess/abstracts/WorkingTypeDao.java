package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.WorkingType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkingTypeDao extends JpaRepository<WorkingType, Integer> {
}
