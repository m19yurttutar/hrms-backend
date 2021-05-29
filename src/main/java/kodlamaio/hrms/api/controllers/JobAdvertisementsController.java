package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobadvertisement")
public class JobAdvertisementsController {
    private JobAdvertisementService jobAdvertisementService;

    @Autowired
    public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) { this.jobAdvertisementService = jobAdvertisementService; }

    @GetMapping("/getall")
    public DataResult<List<JobAdvertisement>> getAll(){
        return jobAdvertisementService.getAll();
    }

    @GetMapping("/getByActivityStatus")
    public DataResult<List<JobAdvertisement>> getByActivityStatus(){
        return jobAdvertisementService.getByActivityStatus();
    }

    @GetMapping("/getByActivityStatusSorted")
    public DataResult<List<JobAdvertisement>> getByActivityStatusSorted(){
        return jobAdvertisementService.getByActivityStatusSorted();
    }

    @GetMapping("/getByEmployerIdAndActivityStatus")
    public DataResult<List<JobAdvertisement>> getByEmployer_IdAndActivityStatus(@RequestParam int employerId){
        return jobAdvertisementService.getByEmployer_IdAndActivityStatus(employerId);
    }

    @PostMapping("/add")
    public Result add(@RequestBody JobAdvertisement jobAdvertisement){
        return jobAdvertisementService.add(jobAdvertisement);
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestBody JobAdvertisement jobAdvertisement){
        return jobAdvertisementService.delete(jobAdvertisement);
    }

    @PutMapping("/update")
    public Result update(@RequestBody JobAdvertisement jobAdvertisement){
        return jobAdvertisementService.update(jobAdvertisement);
    }
}
