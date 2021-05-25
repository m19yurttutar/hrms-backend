package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobSeeker;

@RestController
@RequestMapping("/api/jobseekers")
public class JobSeekersController {

    private JobSeekerService jobSeekerService;

    @Autowired
    public JobSeekersController(JobSeekerService jobSeekerService) { this.jobSeekerService = jobSeekerService; }

    @GetMapping("/getall")
    public DataResult<List<JobSeeker>> getAll(){
        return jobSeekerService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody JobSeeker jobSeeker){
        return jobSeekerService.add(jobSeeker);
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestBody JobSeeker jobSeeker){
        return jobSeekerService.delete(jobSeeker);
    }

    @PutMapping("/update")
    public Result update(@RequestBody JobSeeker jobSeeker){ return jobSeekerService.update(jobSeeker); }
}