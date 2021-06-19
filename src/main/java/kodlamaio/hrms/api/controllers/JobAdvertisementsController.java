package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.Result;
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

    @GetMapping("/getById")
    public ResponseEntity<?> getById(Integer id){
        var result = jobAdvertisementService.getById(id);

        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @GetMapping("/getUnconfirmedJobAdvertisement")
    public ResponseEntity<?> getUnconfirmedJobAdvertisement(){
        var result = jobAdvertisementService.getUnconfirmedJobAdvertisement();

        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @GetMapping("/getByActivityStatusAndConfirmationStatus")
    public ResponseEntity<?> getByActivityStatusAndConfirmationStatus(){
        var result = jobAdvertisementService.getByActivityStatusAndConfirmationStatus();

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
    public Result add(@RequestBody JobAdvertisementDto jobAdvertisementDto){
        return jobAdvertisementService.add(jobAdvertisementDto);
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
