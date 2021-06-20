package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.JobAdvertisementConfirmationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisementConfirmation;
import kodlamaio.hrms.entities.dtos.JobAdvertisementConfirmationDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobAdvertisementConfirmations")
@CrossOrigin
public class JobAdvertisementConfirmationsController {

    private final JobAdvertisementConfirmationService jobAdvertisementConfirmationService;

    @Autowired
    public JobAdvertisementConfirmationsController(JobAdvertisementConfirmationService jobAdvertisementConfirmationService) { this.jobAdvertisementConfirmationService = jobAdvertisementConfirmationService; }

    @GetMapping("/getAll")
    public DataResult<List<JobAdvertisementConfirmation>> getAll(){
        return jobAdvertisementConfirmationService.getAll();
    }

    @PutMapping("/update")
    public Result update(@RequestBody JobAdvertisementConfirmationDto jobAdvertisementConfirmationDto){
        return jobAdvertisementConfirmationService.update(jobAdvertisementConfirmationDto);
    }
}
