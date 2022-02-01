package uz.ruzyume.porfolio_block.service.securtiy;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import uz.ruzyume.porfolio_block.domain.security.Permission;
import uz.ruzyume.porfolio_block.model.GenericDto;
import uz.ruzyume.porfolio_block.model.security.permission.PermissionAddDto;
import uz.ruzyume.porfolio_block.repository.security.PermissionRepository;

@Service

public class PermissionService {

    private final PermissionRepository repository;
    private final ObjectMapper objectMapper;

    public PermissionService(PermissionRepository repository, ObjectMapper objectMapper) {
        this.repository = repository;
        this.objectMapper = objectMapper;
    }
    public GenericDto add(final PermissionAddDto addDto){
        Permission permission = new Permission();
        try {
            objectMapper.updateValue(permission, addDto);
        } catch (JsonMappingException e) {
            e.printStackTrace();
        }
        Long id = repository.save(permission).getId();
        return GenericDto.builder().id(id).build();
    }
}
