package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.WorkingTypeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.WorkingType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public DataResult<List<WorkingType>> getAll(){
        return workingTypeService.getAll();
    }
}
