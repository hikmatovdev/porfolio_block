package uz.ruzyume.porfolio_block.repository.security;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.ruzyume.porfolio_block.domain.security.Permission;

public interface PermissionRepository extends JpaRepository<Permission, Long> {
   Permission findByIdAndDeletedFalse(final Long id);
}
