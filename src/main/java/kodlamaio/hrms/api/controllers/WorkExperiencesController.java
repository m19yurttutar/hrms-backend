package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.WorkExperienceService;
import kodlamaio.hrms.entities.concretes.WorkExperience;
import kodlamaio.hrms.entities.dtos.WorkExperienceDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/workExperiences")
public class WorkExperiencesController {

    private final WorkExperienceService workExperienceService;

    @Autowired
    public WorkExperiencesController(WorkExperienceService workExperienceService) { this.workExperienceService = workExperienceService; }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll(){
        var result = workExperienceService.getAll();

        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @GetMapping("/getByCurriculumVitaeJobSeekerIdSortedByQuitYear")
    public ResponseEntity<?> getByCurriculumVitaeJobSeekerIdSortedByQuitYear(@RequestParam Integer jobSeekerId){
        var result = workExperienceService.getByCurriculumVitaeJobSeekerIdSortedByQuitYear(jobSeekerId);

        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody WorkExperienceDto workExperienceDto){
        var result = workExperienceService.add(workExperienceDto);

        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody WorkExperience workExperience){
        var result = workExperienceService.delete(workExperience);

        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody WorkExperience workExperience){
        var result = workExperienceService.update(workExperience);

        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }
}
