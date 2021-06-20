package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.ConnectionService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ConnectionDao;
import kodlamaio.hrms.entities.concretes.Connection;
import kodlamaio.hrms.entities.dtos.ConnectionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConnectionManager implements ConnectionService {

    private final ConnectionDao connectionDao;

    @Autowired
    public ConnectionManager(ConnectionDao connectionDao) {
        this.connectionDao = connectionDao;
    }

    @Override
    public DataResult<List<Connection>> getAll() {
        return new SuccessDataResult<>(connectionDao.findAll(), Messages.connectionsListed);
    }

    @Override
    public Result add(Connection connection) {
        connectionDao.save(connection);
        return new SuccessResult(Messages.connectionAdded);
    }

    @Override
    public Result delete(Connection connection) {
        connectionDao.delete(connection);
        return new SuccessResult(Messages.connectionDeleted);
    }

    @Override
    public Result update(ConnectionDto connectionDto) {
        Connection connection = connectionDtoToConnectionConverter(connectionDto);
        connectionDao.save(connection);
        return new SuccessResult(Messages.connectionUpdated);
    }

    //This method converts the ConnectionDto object into a form that the database will recognize.
    private Connection connectionDtoToConnectionConverter(ConnectionDto connectionDto){
        //This value will hold the connectionId of the logged-in user when the JSON Web Token was written.
        int connectionId = 1;

        return new Connection(connectionId, connectionDto.getGithubAccountLink(), connectionDto.getLinkedinAccountLink());
    }
}
