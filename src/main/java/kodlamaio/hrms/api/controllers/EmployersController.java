package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.core.utilities.results.DataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employer;

import java.util.List;

@RestController
@RequestMapping("/api/employers")
public class EmployersController {

    private final EmployerService employerService;

    @Autowired
    public EmployersController(EmployerService employerService) { this.employerService = employerService; }

    @GetMapping("/getAll")
    public DataResult<List<Employer>> getAll(){ return employerService.getAll(); }

    @PostMapping("/add")
    public Result add(@RequestBody Employer employer){
        return employerService.add(employer);
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestBody Employer employer){
        return employerService.delete(employer);
    }

    @PutMapping("/update")
    public Result update(@RequestBody Employer employer){
        return employerService.update(employer);
    }
}
