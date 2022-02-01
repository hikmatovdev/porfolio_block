package uz.ruzyume.porfolio_block.domain.security;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.GrantedAuthority;
import uz.ruzyume.porfolio_block.domain._AbstractDomain;

import javax.persistence.Entity;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PACKAGE)
public class Permission extends _AbstractDomain implements GrantedAuthority {

    String name;

    String authority;
}
