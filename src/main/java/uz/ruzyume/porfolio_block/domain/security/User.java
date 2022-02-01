package uz.ruzyume.porfolio_block.domain.security;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import uz.ruzyume.porfolio_block.domain._AbstractDomain;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

import static lombok.AccessLevel.*;


@Entity(name = "auth_user")
@Data
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = PRIVATE)

public class User extends _AbstractDomain implements UserDetails {

    String phoneNumber;

    String email;

    String username;

    LocalDateTime lastSignInTime;

    String password;

    boolean accountNonExpired;

    boolean accountNonLocked;

    boolean credentialsNonExpired;

    boolean enabled;



//    @ManyToMany(cascade = {CascadeType.ALL})
//    @JoinTable(name = "auth_users_roles", joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")}
//         ,inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
    @ManyToOne
    Role role;


    @Override
    public List<Permission> getAuthorities() {
        return role.getPermissions();
    }




}



