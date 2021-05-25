package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.AuthService;

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

    private AuthService authService;

    @Autowired
    public AuthController(AuthService authService) { this.authService = authService; }

    @PostMapping("/register")
    public Result register(@RequestBody JobSeekerForRegisterDto jobSeekerForRegisterDto, String confirmPassword){
        return authService.register(jobSeekerForRegisterDto, confirmPassword);
    }
}