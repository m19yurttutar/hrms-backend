package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Connection;
import kodlamaio.hrms.entities.dtos.ConnectionDto;

import java.util.List;

public interface ConnectionService {
    DataResult<List<Connection>> getAll();
    Result add(Connection connection);
    Result delete(Connection connection);
    Result update(ConnectionDto connectionDto);
}
