package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.business.abstracts.JobPositionService;
import kodlamaio.hrms.entities.concretes.JobPosition;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobPositions")
@CrossOrigin
public class JobPositionsController {

    private final JobPositionService jobPositionService;

    @Autowired
    public JobPositionsController(JobPositionService jobPositionService) { this.jobPositionService = jobPositionService; }

    @GetMapping("/getAll")
    public DataResult<List<JobPosition>> getAll(){
        return jobPositionService.getAll();
    }
}
