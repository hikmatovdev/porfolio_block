package uz.ruzyume.porfolio_block.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.ruzyume.porfolio_block.domain._Language;

import java.util.List;
import java.util.Optional;

public interface LanguageRepository extends JpaRepository<_Language, Long> {

    Optional<_Language> findByIdAndDeletedFalse(Long id);

    List<_Language> findAllByDeletedFalse();
}
