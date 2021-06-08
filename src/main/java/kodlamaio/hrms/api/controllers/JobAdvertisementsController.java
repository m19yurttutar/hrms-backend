package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.entities.dtos.JobAdvertisementDto;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/jobAdvertisements")
@CrossOrigin
public class JobAdvertisementsController {

    private final JobAdvertisementService jobAdvertisementService;

    @Autowired
    public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) { this.jobAdvertisementService = jobAdvertisementService; }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll(){
        var result = jobAdvertisementService.getAll();

        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @GetMapping("/getByActivityStatus")
    public ResponseEntity<?> getByActivityStatus(){
        var result = jobAdvertisementService.getByActivityStatus();

        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @GetMapping("/getByActivityStatusSorted")
    public ResponseEntity<?> getByActivityStatusSorted(){
        var result = jobAdvertisementService.getByActivityStatusSorted();

        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @GetMapping("/getByEmployerIdAndActivityStatus")
    public ResponseEntity<?> getByEmployer_IdAndActivityStatus(@RequestParam Integer employerId){
        var result = jobAdvertisementService.getByEmployer_IdAndActivityStatus(employerId);

        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody JobAdvertisementDto jobAdvertisementDto){
        var result = jobAdvertisementService.add(jobAdvertisementDto);

        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody JobAdvertisement jobAdvertisement){
        var result = jobAdvertisementService.delete(jobAdvertisement);

        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody JobAdvertisement jobAdvertisement){
        var result = jobAdvertisementService.update(jobAdvertisement);

        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }
}
