package uz.ruzyume.porfolio_block.model.security.permission;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class PermissionDto  {

    private String name;

    private String authority;
}
