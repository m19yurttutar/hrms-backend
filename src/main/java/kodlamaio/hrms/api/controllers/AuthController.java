package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import kodlamaio.hrms.business.abstracts.AuthService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.JobSeeker;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private AuthService<JobSeeker> jobSeekerAuthService;
    private AuthService<Employer> employerAuthService;

    @Autowired
    public AuthController(AuthService<JobSeeker> jobSeekerAuthService, AuthService<Employer> employerAuthService){
        this.jobSeekerAuthService = jobSeekerAuthService;
        this.employerAuthService = employerAuthService;
    }

    @PostMapping("/jobseekerregister")
    public Result JobSeekerRegister(@RequestBody JobSeeker jobSeeker,@RequestParam String confirmPassword){
        return jobSeekerAuthService.register(jobSeeker, confirmPassword);
    }

    @PostMapping("/employerregister")
    public Result EmployerRegister(@RequestBody Employer employer,@RequestParam String confirmPassword){
        return employerAuthService.register(employer, confirmPassword);
    }
}
