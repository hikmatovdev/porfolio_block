package uz.ruzyume.porfolio_block.repository.security;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.ruzyume.porfolio_block.domain.security.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {



   User findByUsernameAndDeletedFalse(final String username);
}
