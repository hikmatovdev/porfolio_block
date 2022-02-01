package uz.ruzyume.porfolio_block.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.ruzyume.porfolio_block.domain._Education;
import uz.ruzyume.porfolio_block.model.EducationDto;

import java.util.List;
import java.util.Optional;

public interface EducationRepository extends JpaRepository<_Education, Long> {

    Optional<_Education> findByIdAndDeletedFalse(Long id);

    List<EducationDto> findAllByDeletedFalse();

}
