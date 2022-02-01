package uz.ruzyume.porfolio_block.service.securtiy;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import uz.ruzyume.porfolio_block.domain.security.Permission;
import uz.ruzyume.porfolio_block.domain.security.Role;
import uz.ruzyume.porfolio_block.model.GenericDto;
import uz.ruzyume.porfolio_block.model.security.role.AttachPermissionDto;
import uz.ruzyume.porfolio_block.model.security.role.RoleAddDto;
import uz.ruzyume.porfolio_block.repository.security.PermissionRepository;
import uz.ruzyume.porfolio_block.repository.security.RoleRepository;

import static java.lang.Boolean.TRUE;

@Service
public class RoleService {

    private final RoleRepository roleRepository;
    private final PermissionRepository repository;
    private final ObjectMapper objectMapper;

    public RoleService(RoleRepository roleRepository, PermissionRepository repository, ObjectMapper objectMapper) {
        this.roleRepository = roleRepository;
        this.repository = repository;
        this.objectMapper = objectMapper;
    }
    public GenericDto add(final RoleAddDto addDto){
        Role role = new Role();
        try {
            objectMapper.updateValue(role, addDto);
        } catch (JsonMappingException e) {
            e.printStackTrace();
        }
        Long id = roleRepository.save(role).getId();
        return GenericDto.builder().id(id).build();
    }
    public Boolean attachPermission(final AttachPermissionDto dto){
        Role role = roleRepository.findByIdAndDeletedFalse(dto.getRoleId());

        if (role == null)
            throw  new RuntimeException("nmadur qaytadi!");

            Permission permission = repository.findByIdAndDeletedFalse(dto.getPermissionId());

            if(permission == null)

                throw new RuntimeException("yana nmadur qaytadi!");

            if (role.getPermissions().contains(permission)){
                throw new RuntimeException("Permission has already been attached!");
            }
            role.getPermissions().add(permission);
            roleRepository.save(role);
            return TRUE;
    }
}
