package uz.ruzyume.porfolio_block.model.security.user;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import uz.ruzyume.porfolio_block.domain.security.Role;
import uz.ruzyume.porfolio_block.model.GenericDto;
import uz.ruzyume.porfolio_block.model.security.role.RoleDto;

import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Data
@SuperBuilder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDto {
    String email;

    String userName;

    LocalDateTime lastSignInTime;

    String phoneNumber;

    String fullName;

    String password;

    String username;

    boolean accountNonExpired;

    boolean accountNonLocked;

    boolean credentialsNonExpired;

    boolean enabled;

    RoleDto role;

}
