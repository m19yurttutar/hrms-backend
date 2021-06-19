package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.SystemEmployeeService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.SystemEmployee;
import kodlamaio.hrms.entities.dtos.SystemEmployeeDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/systemEmployees")
public class SystemEmployeesController {

    private final SystemEmployeeService systemEmployeeService;

    @Autowired
    public SystemEmployeesController(SystemEmployeeService systemEmployeeService) { this.systemEmployeeService = systemEmployeeService; }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll(){
        var result = systemEmployeeService.getAll();

        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @PostMapping("/add")
    public Result add(@RequestBody SystemEmployeeDto systemEmployeeDto){
        return systemEmployeeService.add(systemEmployeeDto);
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestBody SystemEmployee systemEmployee){
        return systemEmployeeService.delete(systemEmployee);
    }

    @PutMapping("/update")
    public Result update(@RequestBody SystemEmployee systemEmployee){
        return systemEmployeeService.update(systemEmployee);
    }
}
