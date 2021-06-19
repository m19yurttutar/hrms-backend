package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {
    List<JobAdvertisement> getByJobAdvertisementConfirmation_EditDateAndJobAdvertisementConfirmation_ConfirmationStatus(LocalDate editDate, boolean confirmationStatus);
    List<JobAdvertisement> getByActivityStatusTrueAndJobAdvertisementConfirmation_ConfirmationStatus(boolean confirmationStatus);
    List<JobAdvertisement> getByActivityStatusTrue(Sort sort);
    List<JobAdvertisement> getByEmployer_IdAndActivityStatusTrue(Integer employerId);
    JobAdvertisement getById(Integer id);
}
