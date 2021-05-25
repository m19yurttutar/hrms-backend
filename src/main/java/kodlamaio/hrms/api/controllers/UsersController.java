package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.User;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    private UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getall")
    public DataResult<List<User>> getAll(){
        return userService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody User user){
        return userService.add(user);
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestBody User user){
        return userService.add(user);
    }

    @PutMapping("/update")
    public Result update(@RequestBody User user){
        return userService.update(user);
    }
}
