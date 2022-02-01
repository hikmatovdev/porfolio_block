package uz.ruzyume.porfolio_block.service.securtiy;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NonNull;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import uz.ruzyume.porfolio_block.domain.security.Role;
import uz.ruzyume.porfolio_block.domain.security.User;
import uz.ruzyume.porfolio_block.model.GenericDto;
import uz.ruzyume.porfolio_block.model.security.user.UserAddDto;
import uz.ruzyume.porfolio_block.model.security.user.UserDto;
import uz.ruzyume.porfolio_block.repository.security.RoleRepository;
import uz.ruzyume.porfolio_block.repository.security.UserRepository;

@Service
public class UserService implements UserDetailsService {

  private final UserRepository userRepository;
  private final RoleRepository repository;
  private final ObjectMapper objectMapper;


    public UserService(UserRepository userRepository, RoleRepository repository, ObjectMapper objectMapper) {
        this.userRepository = userRepository;
        this.repository = repository;
        this.objectMapper = objectMapper;
    }
    public GenericDto add(@NonNull final UserAddDto userDto){
        Role role = repository.findByIdAndDeletedFalse(userDto.getRoleId());

        if (role==null){
            throw new RuntimeException("User role not found by this id ");
        }
        User user = new User();
        try {
            objectMapper.updateValue(user, userDto);
        } catch (JsonMappingException e) {
            e.printStackTrace();
        }
        user.setRole(role);

       Long id =  userRepository.save(user).getId();
        return GenericDto.builder().id(id).build();
    }



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       User userOptional = userRepository.findByUsernameAndDeletedFalse(username);
        if (userOptional != null){
            return userOptional;
        }else throw  new  UsernameNotFoundException(
                String.format("User with this[username] %s not found", username ));

    }

}
