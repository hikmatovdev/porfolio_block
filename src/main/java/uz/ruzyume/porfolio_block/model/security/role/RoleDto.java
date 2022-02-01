package uz.ruzyume.porfolio_block.model.security.role;

import lombok.*;
import lombok.experimental.SuperBuilder;
import uz.ruzyume.porfolio_block.model.GenericDto;

@Getter
@Setter
@SuperBuilder
public class RoleDto extends GenericDto{

    private String name;

    private String code;
}
