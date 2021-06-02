package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.CurriculumVitaeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CurriculumVitae;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/curriculumVitaes")
public class CurriculumVitaeController {

    private final CurriculumVitaeService curriculumVitaeService;

    @Autowired
    public CurriculumVitaeController(CurriculumVitaeService curriculumVitaeService) { this.curriculumVitaeService = curriculumVitaeService; }

    @GetMapping("/getAll")
    public DataResult<List<CurriculumVitae>> getAll(){ return curriculumVitaeService.getAll(); }

    @GetMapping("/getByJobSeekerId")
    public DataResult<CurriculumVitae> getByJobSeekerId(@RequestParam Integer jobSeekerId){ return curriculumVitaeService.getByJobSeekerId(jobSeekerId); }

    @PostMapping("/add")
    public Result add(@RequestBody CurriculumVitae curriculumVitae){
        return curriculumVitaeService.add(curriculumVitae);
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestBody CurriculumVitae curriculumVitae){
        return curriculumVitaeService.delete(curriculumVitae);
    }

    @PutMapping("/update")
    public Result update(@RequestBody CurriculumVitae curriculumVitae){
        return curriculumVitaeService.update(curriculumVitae);
    }
}
