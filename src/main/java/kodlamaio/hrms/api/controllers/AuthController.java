package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import kodlamaio.hrms.business.abstracts.AuthService;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.JobSeeker;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService<JobSeeker> jobSeekerAuthService;
    private final AuthService<Employer> employerAuthService;

    @Autowired
    public AuthController(AuthService<JobSeeker> jobSeekerAuthService, AuthService<Employer> employerAuthService){
        this.jobSeekerAuthService = jobSeekerAuthService;
        this.employerAuthService = employerAuthService;
    }

    @PostMapping("/jobSeekerRegister")
    public ResponseEntity<?> JobSeekerRegister(@RequestBody JobSeeker jobSeeker, @RequestParam String confirmPassword){

        var result = jobSeekerAuthService.register(jobSeeker, confirmPassword);

        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }

    @PostMapping("/employerRegister")
    public ResponseEntity<?> EmployerRegister( @RequestBody Employer employer, @RequestParam String confirmPassword){

        var result = employerAuthService.register(employer, confirmPassword);

        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().body(result);
    }
}
