package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
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
@CrossOrigin
public class AuthController{

    private final AuthService<JobSeekerDto> jobSeekerAuthService;
    private final AuthService<EmployerDto> employerAuthService;

    @Autowired
    public AuthController(AuthService<JobSeekerDto> jobSeekerAuthService, AuthService<EmployerDto> employerAuthService){
        this.jobSeekerAuthService = jobSeekerAuthService;
        this.employerAuthService = employerAuthService;
    }

    @PostMapping("/jobSeekerRegister")
    public Result JobSeekerRegister(@RequestBody JobSeekerDto jobSeekerDto){
        return jobSeekerAuthService.register(jobSeekerDto);
    }

    @PostMapping("/employerRegister")
    public Result EmployerRegister(@RequestBody EmployerDto employerDto){
        return employerAuthService.register(employerDto);
    }
}
