package kodlamaio.hrms.business.concretes;

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
        return new SuccessDataResult<>(userDao.findAll(),Messages.usersListed);
    }

    @Override
    public DataResult<User> getByEmail(String email){
        List<User> users = userDao.findAll();

        for (User user : users){
            if (user.getEmail().equals(email)){
                return new SuccessDataResult<>(user, Messages.userListed);
            }
        }
        return new ErrorDataResult<>("Bu email adresine sahip kullanıcı bulunamadı.");
    }

    @Override
    public Result add(User user) {
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
}
