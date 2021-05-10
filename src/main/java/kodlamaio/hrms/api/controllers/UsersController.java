package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    private UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getall")
    public List<User> getAll(){
        return userService.getAll();
    }

    @GetMapping("/get/{id}")
    public List<User> get(@PathVariable int id){
        return userService.getAll();
    }

    @PostMapping("/add")
    public void add(@RequestBody User user){
        userService.add(user);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody User user){
        userService.add(user);
    }

    @PutMapping("/update")
    public void update(@RequestBody User user){
        userService.update(user);
    }
}
