package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.entities.concretes.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> get(int id);
    List<User> getAll();
    void add(User user);
    void delete(User user);
    void update(User user);
}
