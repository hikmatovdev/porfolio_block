package uz.ruzyume.porfolio_block.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.ruzyume.porfolio_block.domain._AboutMe;

import java.util.List;
import java.util.Optional;

public interface AboutMeRepository extends JpaRepository<_AboutMe, Long> {

    Optional<_AboutMe> findByIdAndDeletedFalse(Long id);

    List<_AboutMe> findAllByDeletedFalse();
}
