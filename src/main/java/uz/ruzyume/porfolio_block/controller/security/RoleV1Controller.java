package uz.ruzyume.porfolio_block.controller.security;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import uz.ruzyume.porfolio_block.model.GenericDto;
import uz.ruzyume.porfolio_block.model.security.role.AttachPermissionDto;
import uz.ruzyume.porfolio_block.model.security.role.RoleAddDto;
import uz.ruzyume.porfolio_block.service.securtiy.RoleService;

@RestController
@RequestMapping("api/role/v1")
public class RoleV1Controller {
    private final RoleService roleService;

    public RoleV1Controller(RoleService roleService) {
        this.roleService = roleService;
    }


    @PreAuthorize(value = "hasAuthority('ROLE_ADD')")
    @PostMapping
    private GenericDto add(@RequestBody final RoleAddDto addDto){
        return roleService.add(addDto);
    }
    @PutMapping
    private Boolean attachPermission(@RequestBody final AttachPermissionDto attachPermissionDto){
        return roleService.attachPermission(attachPermissionDto);
    }


}
