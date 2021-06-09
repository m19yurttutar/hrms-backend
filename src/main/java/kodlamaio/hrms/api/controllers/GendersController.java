package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/genders")
@CrossOrigin
public class GendersController {

    private GenderService genderService;

    @Autowired
    public GendersController(GenderService genderService){
        this.genderService = genderService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll(){
        var result = genderService.getAll();

        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }
}
