package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.core.utilities.business.BusinessRules;
import kodlamaio.hrms.core.utilities.results.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.User;

import java.util.List;

@Service
public class UserManager implements UserService {

    private UserDao userDao;

    @Autowired
    public UserManager(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public DataResult<List<User>> getAll() {
        return new SuccessDataResult<>(userDao.findAll(), Messages.usersListed);
    }

    @Override
    public DataResult<User> getByEmail(String email) {
        return new SuccessDataResult<>(userDao.getByEmail(email), Messages.userListed);
    }

    @Override
    public Result add(User user) {

        Result businessResult = BusinessRules.run(CheckIfEmailExists(user.getEmail()));

        if (businessResult != null){
            return businessResult;
        }

        userDao.save(user);
        return new SuccessResult(Messages.userAdded);
    }

    @Override
    public Result delete(User user) {
        userDao.delete(user);
        return new SuccessResult(Messages.userDeleted);
    }

    @Override
    public Result update(User user) {
        userDao.save(user);
        return new SuccessResult(Messages.userUpdated);
    }

    private Result CheckIfEmailExists(String email) {
        var result = this.getByEmail(email).getData();

        if (result == null) {
            return new SuccessResult();
        }
        return new ErrorResult("Bu email adresi daha önce kullanılmış.");
    }
}
