package uz.ruzyume.porfolio_block.service.securtiy;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.ruzyume.porfolio_block.provider.JwtProvider;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    List<User> users = new ArrayList<>();
    public UserService(PasswordEncoder passwordEncoder) {
        users.add(new User("admin", passwordEncoder.encode("123"), List.of()));
        users.add(new User("user", passwordEncoder.encode("123"),List.of()));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> first = users.stream().filter(user -> user.getUsername().equals(username)).findFirst();

        if (first.isPresent()){
            return first.get();
        }else throw  new  UsernameNotFoundException(
                String.format("User with this[username] %s not found", username ));

    }

}
