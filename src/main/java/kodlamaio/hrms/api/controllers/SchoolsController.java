package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.SchoolService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.School;
import kodlamaio.hrms.entities.dtos.SchoolDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schools")
public class SchoolsController {

    private final SchoolService schoolService;

    @Autowired
    public SchoolsController(SchoolService schoolService) { this.schoolService = schoolService; }

    @GetMapping("/getAll")
    public DataResult<List<School>> getAll(){ return schoolService.getAll(); }

    @PostMapping("/add")
    public Result add(@RequestBody SchoolDto schoolDto){
        return schoolService.add(schoolDto);
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestBody School school){
        return schoolService.delete(school);
    }
}
