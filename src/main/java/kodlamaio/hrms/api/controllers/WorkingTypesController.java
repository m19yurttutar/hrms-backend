package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.WorkingTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/workingTypes")
@CrossOrigin
public class WorkingTypesController {

    private final WorkingTypeService workingTypeService;

    @Autowired
    public WorkingTypesController(WorkingTypeService workingTypeService) {
        this.workingTypeService = workingTypeService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll(){
        var result = workingTypeService.getAll();

        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }
}
