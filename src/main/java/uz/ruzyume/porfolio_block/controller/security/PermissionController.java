package uz.ruzyume.porfolio_block.controller.security;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.ruzyume.porfolio_block.model.GenericDto;
import uz.ruzyume.porfolio_block.model.security.permission.PermissionAddDto;
import uz.ruzyume.porfolio_block.service.securtiy.PermissionService;

@RestController
@RequestMapping("api/permission/v1")
public class PermissionController {

    private final PermissionService permissionService;

    public PermissionController(PermissionService permissionService) {
        this.permissionService = permissionService;
    }
    @PostMapping
    @PreAuthorize(value = "hasAuthority('PERMSSION_ADD')")
    private GenericDto add(@RequestBody final PermissionAddDto addDto){
        return permissionService.add(addDto);
    }
}
