package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.SkillService;
import kodlamaio.hrms.entities.concretes.Skill;
import kodlamaio.hrms.entities.dtos.SkillDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/skills")
public class SkillsController {

    private final SkillService skillService;

    @Autowired
    public SkillsController(SkillService skillService) { this.skillService = skillService; }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll(){
        var result = skillService.getAll();

        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody SkillDto skillDto){
        var result = skillService.add(skillDto);

        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody Skill skill){
        var result = skillService.delete(skill);

        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody Skill skill){
        var result = skillService.update(skill);

        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }
}
