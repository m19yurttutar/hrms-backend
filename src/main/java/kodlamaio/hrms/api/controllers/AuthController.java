package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.entities.dtos.EmployerDto;
import kodlamaio.hrms.entities.dtos.JobSeekerDto;
import kodlamaio.hrms.business.abstracts.AuthService;
import kodlamaio.hrms.entities.concretes.Employer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController{

    private final AuthService<JobSeekerDto> jobSeekerAuthService;
    private final AuthService<EmployerDto> employerAuthService;

    @Autowired
    public AuthController(AuthService<JobSeekerDto> jobSeekerAuthService, AuthService<EmployerDto> employerAuthService){
        this.jobSeekerAuthService = jobSeekerAuthService;
        this.employerAuthService = employerAuthService;
    }

    @PostMapping("/jobSeekerRegister")
    public ResponseEntity<?> JobSeekerRegister(@Valid @RequestBody JobSeekerDto jobSeekerDto, @RequestParam String confirmPassword){

        var result = jobSeekerAuthService.register(jobSeekerDto, confirmPassword);

        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @PostMapping("/employerRegister")
    public ResponseEntity<?> EmployerRegister(@RequestBody EmployerDto employerDto, @RequestParam String confirmPassword){

        var result = employerAuthService.register(employerDto, confirmPassword);

        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }
}
