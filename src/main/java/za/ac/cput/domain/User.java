package za.ac.cput.domain;

//import java.util.List;
//import javax.persistence.*;
//import lombok.Data;
//
//@Data
//@Entity
//@Table(name="users")
//public class User {
//
//    @Id
//    @GeneratedValue
//    @Column(name="user_id")
//    private Integer id;
//
//    @Column(name="user_name")
//    private String name;
//
//    @Column(name="user_passwd")
//    private String password;
//
//    @Column(name="user_email")
//    private String email;
//
//    @ElementCollection(fetch= FetchType.EAGER)
//    @CollectionTable(
//            name="roles",
//            joinColumns = @JoinColumn(name="user_id")
//    )
//    @Column(name="user_role")
//    private List<String> roles;
//
//}