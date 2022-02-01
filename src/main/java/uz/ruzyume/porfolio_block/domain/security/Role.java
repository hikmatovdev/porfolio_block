package uz.ruzyume.porfolio_block.domain.security;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;
import uz.ruzyume.porfolio_block.domain._AbstractDomain;
import uz.ruzyume.porfolio_block.model.security.role.RoleDto;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Role extends _AbstractDomain {

    String name;

    String code;

    @ManyToMany(cascade ={CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinTable(name = "role_permission",
        joinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")},
        inverseJoinColumns = {@JoinColumn(name = "permission_id", referencedColumnName = "id")})
    private List<Permission> permissions;

    public RoleDto convert(){
        return RoleDto.builder()
                .name(name)
                .code(code)
                .id(id)
                .build();
    }
}
