package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Login;
import za.ac.cput.service.LoginService;

import java.util.Set;

@RestController
@RequestMapping("/logins") // The base URL path for this controller
public class LoginController {

    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("save")
    public Login save(@RequestBody Login login) {
        return loginService.save(login);
    }

    @GetMapping("read/{id}")
    public Login read(@PathVariable String id) {
        return loginService.read(id);
    }

    @PutMapping("update/{id}")
    public Login update(@PathVariable String id, @RequestBody Login login) {
        // Implement the update logic if needed
        return loginService.update(login);
    }

    @DeleteMapping("delete/{id}")
    public boolean delete(@PathVariable String id) {
        return loginService.delete(id);
    }

    @GetMapping("all")
    public Set<Login> findAll() {
        return loginService.findAll();
    }
}
