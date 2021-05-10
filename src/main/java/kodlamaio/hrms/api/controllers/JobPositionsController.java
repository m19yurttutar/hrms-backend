package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.JobPositionService;
import kodlamaio.hrms.entities.concretes.JobPosition;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/jobpositions")
public class JobPositionsController {

    private JobPositionService jobPositionService;

    public JobPositionsController(JobPositionService jobPositionService) {
        this.jobPositionService = jobPositionService;
    }

    @GetMapping("/getall")
    public List<JobPosition> getAll(){
        return jobPositionService.getAll();
    }

    @GetMapping("/get/{id}")
    public Optional<JobPosition> get(@PathVariable int id){
        return jobPositionService.get(id);
    }

    @PostMapping("/add")
    public void add(@RequestBody JobPosition jobPosition){
        jobPositionService.add(jobPosition);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody JobPosition jobPosition){
        jobPositionService.delete(jobPosition);
    }

    @PutMapping("/update")
    public void update(@RequestBody JobPosition jobPosition){
        jobPositionService.update(jobPosition);
    }
}
