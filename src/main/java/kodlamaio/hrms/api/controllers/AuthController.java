package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.entities.dtos.JobSeekerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import kodlamaio.hrms.business.abstracts.AuthService;
import kodlamaio.hrms.entities.concretes.Employer;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService<JobSeekerDto> jobSeekerDtoAuthService;
    private final AuthService<Employer> employerAuthService;

    @Autowired
    public AuthController(AuthService<JobSeekerDto> jobSeekerDtoAuthService, AuthService<Employer> employerAuthService){
        this.jobSeekerDtoAuthService = jobSeekerDtoAuthService;
        this.employerAuthService = employerAuthService;
    }

    @PostMapping("/jobSeekerRegister")
    public ResponseEntity<?> JobSeekerRegister(@RequestBody JobSeekerDto jobSeekerDto, @RequestParam String confirmPassword){

        var result = jobSeekerDtoAuthService.register(jobSeekerDto, confirmPassword);

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
