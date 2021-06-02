package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.Connection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConnectionDao extends JpaRepository<Connection, Integer> {
}
