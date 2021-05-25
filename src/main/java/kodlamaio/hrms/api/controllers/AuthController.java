package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.AuthService;

import kodlamaio.hrms.entities.DTOs.EmployerForRegisterDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.DTOs.JobSeekerForRegisterDto;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private AuthService<JobSeekerForRegisterDto> jobSeekerForRegisterDtoAuthService;
    private AuthService<EmployerForRegisterDto> employerForRegisterDtoAuthService;

    @Autowired
    public AuthController(AuthService<JobSeekerForRegisterDto> jobSeekerForRegisterDtoAuthService, AuthService<EmployerForRegisterDto> employerForRegisterDtoAuthService) {
        this.jobSeekerForRegisterDtoAuthService = jobSeekerForRegisterDtoAuthService;
        this.employerForRegisterDtoAuthService = employerForRegisterDtoAuthService;
    }

    @PostMapping("/jobseekerregister")
    public Result jobSeekerRegister(@RequestBody JobSeekerForRegisterDto jobSeekerForRegisterDto, String confirmPassword){
        return jobSeekerForRegisterDtoAuthService.register(jobSeekerForRegisterDto, confirmPassword);
    }

    @PostMapping("/employerregister")
    public Result employerRegister(@RequestBody EmployerForRegisterDto employerForRegisterDto, String confirmPassword){
        return employerForRegisterDtoAuthService.register(employerForRegisterDto, confirmPassword);
    }
}
