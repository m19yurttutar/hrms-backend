package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.JobPositionService;
import kodlamaio.hrms.dataAccess.abstracts.JobPositionDao;
import kodlamaio.hrms.entities.concretes.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobPositionManager implements JobPositionService {

    private JobPositionDao jobPositionDao;

    @Autowired
    public JobPositionManager(JobPositionDao jobPositionDao) {
        this.jobPositionDao = jobPositionDao;
    }

    @Override
    public Optional<JobPosition> get(int id) {
        return jobPositionDao.findById(id);
    }

    @Override
    public List<JobPosition> getAll() {
        return jobPositionDao.findAll();
    }

    @Override
    public void add(JobPosition jobPosition) {
        jobPositionDao.save(jobPosition);
    }

    @Override
    public void delete(JobPosition jobPosition) {
        jobPositionDao.delete(jobPosition);
    }

    @Override
    public void update(JobPosition jobPosition) {
        jobPositionDao.save(jobPosition);
    }
}
