package za.ac.cput.service.impl;

//import java.util.Optional;
//import java.util.stream.Collectors;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//import za.ac.cput.domain.User;
//import za.ac.cput.repository.IUserRepository;
//import za.ac.cput.service.UserService;
//
//@Service
//public class UserServiceImpl implements UserService, UserDetailsService {
//
//    @Autowired
//    private IUserRepository repository;
//
//    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;
//
//    @Override
//    public Integer saveUser(User user) {
//        String passwd = user.getPassword();
//        String encodedPasswod = passwordEncoder.encode(passwd);
//        user.setPassword(encodedPasswod);
//        user = repository.save(user);
//        return user.getId();
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String email)
//            throws UsernameNotFoundException {
//
//        Optional<User> opt = Optional.ofNullable(repository.findByUsername(email));
//
//        if (opt.isEmpty())
//            throw new UsernameNotFoundException("User with email: " + email + " not found !");
//        else {
//            User user = opt.get();
//            return new org.springframework.security.core.userdetails.User(
//                    user.getEmail(),
//                    user.getPassword(),
//                    user.getRoles()
//                            .stream()
//                            .map(role -> new SimpleGrantedAuthority(role))
//                            .collect(Collectors.toSet())
//            );
//        }
//
//    }
//}