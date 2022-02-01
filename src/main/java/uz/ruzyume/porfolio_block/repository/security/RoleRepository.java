package uz.ruzyume.porfolio_block.repository.security;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.ruzyume.porfolio_block.domain.security.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByIdAndDeletedFalse(Long id);
}
