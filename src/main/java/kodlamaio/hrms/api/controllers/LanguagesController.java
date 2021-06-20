package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.LanguageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Language;
import kodlamaio.hrms.entities.dtos.LanguageDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/languages")
public class LanguagesController {

    private final LanguageService languageService;

    @Autowired
    public LanguagesController(LanguageService languageService) { this.languageService = languageService; }

    @GetMapping("/getAll")
    public DataResult<List<Language>> getAll(){
        return languageService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody LanguageDto languageDto){
        return languageService.add(languageDto);
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestBody Language language){
        return languageService.delete(language);

    }

    @PutMapping("/update")
    public Result update(@RequestBody Language language){
        return languageService.update(language);
    }
}
