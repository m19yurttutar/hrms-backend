package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.GenderService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.Gender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/genders")
@CrossOrigin
public class GendersController {

    private final GenderService genderService;

    @Autowired
    public GendersController(GenderService genderService){
        this.genderService = genderService;
    }

    @GetMapping("/getAll")
    public DataResult<List<Gender>> getAll(){
        return genderService.getAll();
    }
}
