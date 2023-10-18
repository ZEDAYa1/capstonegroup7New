package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.User;
import za.ac.cput.repository.IUserRepository;
import za.ac.cput.service.UserService;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final IUserRepository repository;

    @Autowired
    public UserServiceImpl(IUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User save(User user) {
        return this.repository.save(user);
    }

    @Override
    public User read(String s) {
        return this.repository.findById(s).orElse(null);
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public boolean delete(String s) {
        if (this.repository.existsById(s)) {
            this.repository.deleteById(s);
            return true;
        }
        return false;
    }


    @Override
    public Set<User> findAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public Set<User> getAll() {
        return null;
    }
}