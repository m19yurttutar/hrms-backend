package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.ConnectionService;
import kodlamaio.hrms.entities.concretes.Connection;
import kodlamaio.hrms.entities.dtos.ConnectionDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/connections")
public class ConnectionsController {

    private final ConnectionService connectionService;

    @Autowired
    public ConnectionsController(ConnectionService connectionService) { this.connectionService = connectionService; }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll(){
        var result = connectionService.getAll();

        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Connection connection){
        var result = connectionService.add(connection);

        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody Connection connection){
        var result = connectionService.delete(connection);

        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody ConnectionDto connectionDto){
        var result = connectionService.update(connectionDto);

        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }
}
