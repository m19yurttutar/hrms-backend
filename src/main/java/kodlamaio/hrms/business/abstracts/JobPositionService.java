package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.entities.concretes.JobPosition;

import java.util.List;
import java.util.Optional;

public interface JobPositionService {
    Optional<JobPosition> get(int id);
    List<JobPosition> getAll();
    void add(JobPosition jobPosition);
    void delete(JobPosition jobPosition);
    void update(JobPosition jobPosition);
}
