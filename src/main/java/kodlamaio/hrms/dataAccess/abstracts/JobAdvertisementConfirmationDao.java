package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.JobAdvertisementConfirmation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobAdvertisementConfirmationDao extends JpaRepository<JobAdvertisementConfirmation, Integer> {
}
