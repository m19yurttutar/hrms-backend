package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.ConnectionService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Connection;
import kodlamaio.hrms.entities.dtos.ConnectionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/connections")
public class ConnectionsController {

    private final ConnectionService connectionService;

    @Autowired
    public ConnectionsController(ConnectionService connectionService) { this.connectionService = connectionService; }

    @GetMapping("/getAll")
    public DataResult<List<Connection>> getAll(){ return connectionService.getAll(); }

    @PostMapping("/add")
    public Result add(@RequestBody Connection connection){
        return connectionService.add(connection);
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestBody Connection connection){
        return connectionService.delete(connection);
    }

    @PutMapping("/update")
    public Result update(@RequestBody ConnectionDto connectionDto){
        return connectionService.update(connectionDto);
    }
}
