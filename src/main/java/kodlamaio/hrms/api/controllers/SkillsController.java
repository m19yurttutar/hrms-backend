package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.SkillService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Skill;
import kodlamaio.hrms.entities.dtos.SkillDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skills")
public class SkillsController {

    private final SkillService skillService;

    @Autowired
    public SkillsController(SkillService skillService) { this.skillService = skillService; }

    @GetMapping("/getAll")
    public DataResult<List<Skill>> getAll(){
        return skillService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody SkillDto skillDto){
        return skillService.add(skillDto);
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestBody Skill skill){
        return skillService.delete(skill);
    }

    @PutMapping("/update")
    public Result update(@RequestBody Skill skill){
        return skillService.update(skill);
    }
}
