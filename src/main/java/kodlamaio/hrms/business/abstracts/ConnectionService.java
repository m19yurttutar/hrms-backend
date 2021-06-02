package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Connection;
import kodlamaio.hrms.entities.dtos.ConnectionDto;

import java.util.List;

public interface ConnectionService {
    DataResult<List<Connection>> getAll();
    Result add(ConnectionDto connectionDto);
    Result delete(Connection connection);
    Result update(Connection connection);
}
