package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.User;
import za.ac.cput.service.UserService;

import java.util.Set;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/update")
    public User update(@RequestBody User user){
        return userService.update(user);
    }

    @PostMapping("save")
    public User createUser(@RequestBody User user) {
        return userService.save(user);
    }

    @GetMapping("read/{id}")
    public User getUser(@PathVariable String id) {
        return userService.read(id);
    }

    @DeleteMapping("delete/{id}")
    public boolean deleteUser(@PathVariable String id) {
        return userService.delete(id);
    }

    @GetMapping("all")
    public Set<User> findAllUsers() {
        return userService.findAll();
    }
}