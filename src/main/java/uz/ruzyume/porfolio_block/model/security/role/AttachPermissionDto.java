package uz.ruzyume.porfolio_block.model.security.role;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AttachPermissionDto {

    private Long roleId;

    private Long permissionId;

}
