package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.SchoolService;
import kodlamaio.hrms.entities.concretes.School;
import kodlamaio.hrms.entities.dtos.SchoolDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/schools")
public class SchoolsController {

    private final SchoolService schoolService;

    @Autowired
    public SchoolsController(SchoolService schoolService) { this.schoolService = schoolService; }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll(){
        var result = schoolService.getAll();

        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @GetMapping("/getByCurriculumVitaeJobSeekerIdSortedByGraduationYear")
    public ResponseEntity<?> getByCurriculumVitaeJobSeekerIdSortedByGraduationYear(Integer jobSeekerId){
        var result = schoolService.getByCurriculumVitaeJobSeekerIdSortedByGraduationYear(jobSeekerId);

        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody SchoolDto schoolDto){
        var result = schoolService.add(schoolDto);

        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody School school){
        var result = schoolService.delete(school);

        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody School school){
        var result = schoolService.update(school);

        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }
}
