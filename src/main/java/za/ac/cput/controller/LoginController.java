package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.Login;
import za.ac.cput.factory.LoginFactory;
import za.ac.cput.service.LoginService;

import java.util.Set;

@RestController
@RequestMapping("capstonegroup7/login")
@Slf4j
public class LoginController {
    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("save")
    public ResponseEntity<Login> save(@RequestBody Login login) {
        log.info("Save request: {}", login);
        Login validatedLogin;
        try {
            validatedLogin = LoginFactory.createLogin(login.getUsername(), login.getPassword());
        } catch (IllegalArgumentException e) {
            log.info("Save request error: {}", e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Login save = loginService.save(validatedLogin);
        return ResponseEntity.ok(save);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        log.info("Delete request{}", id);
        this.loginService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("read/{id}")
    public ResponseEntity<Login> readId(@PathVariable String id) {
        log.info("Read request: {}", id);
        Login login = this.loginService.read(id);
        return ResponseEntity.ok(login);
    }

    @GetMapping("all")
    public ResponseEntity<Set<Login>> findAll() {
        Set<Login> logins = this.loginService.findAll();
        return ResponseEntity.ok(logins);
    }

}