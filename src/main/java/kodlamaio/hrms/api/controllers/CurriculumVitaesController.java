package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.CurriculumVitaeService;
import kodlamaio.hrms.entities.concretes.CurriculumVitae;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/curriculumVitaes")
public class CurriculumVitaesController {

    private final CurriculumVitaeService curriculumVitaeService;

    @Autowired
    public CurriculumVitaesController(CurriculumVitaeService curriculumVitaeService) { this.curriculumVitaeService = curriculumVitaeService; }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll(){
        var result = curriculumVitaeService.getAll();

        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @GetMapping("/getByJobSeekerId")
    public ResponseEntity<?> getByJobSeekerId(@RequestParam Integer jobSeekerId){
        var result = curriculumVitaeService.getByJobSeekerId(jobSeekerId);

        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody CurriculumVitae curriculumVitae){
        var result = curriculumVitaeService.add(curriculumVitae);

        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody CurriculumVitae curriculumVitae){
        var result = curriculumVitaeService.delete(curriculumVitae);

        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody CurriculumVitae curriculumVitae){
        var result = curriculumVitaeService.update(curriculumVitae);

        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }
}
