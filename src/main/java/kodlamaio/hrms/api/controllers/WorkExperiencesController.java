package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.WorkExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.WorkExperience;
import kodlamaio.hrms.entities.dtos.WorkExperienceDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workExperiences")
@CrossOrigin
public class WorkExperiencesController {

    private final WorkExperienceService workExperienceService;

    @Autowired
    public WorkExperiencesController(WorkExperienceService workExperienceService) { this.workExperienceService = workExperienceService; }

    @GetMapping("/getAll")
    public DataResult<List<WorkExperience>> getAll(){
        return workExperienceService.getAll();
    }

    @GetMapping("/getByJobSeekerIdSorted")
    public DataResult<List<WorkExperience>> getByJobSeekerIdSorted(@RequestParam Integer jobSeekerId){
        return workExperienceService.getByJobSeekerIdSorted(jobSeekerId);
    }

    @PostMapping("/add")
    public Result add(@RequestBody WorkExperienceDto workExperienceDto){
        return workExperienceService.add(workExperienceDto);
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestBody WorkExperience workExperience){
        return workExperienceService.delete(workExperience);
    }

    @PutMapping("/update")
    public Result update(@RequestBody WorkExperience workExperience){
        return workExperienceService.update(workExperience);
    }
}
