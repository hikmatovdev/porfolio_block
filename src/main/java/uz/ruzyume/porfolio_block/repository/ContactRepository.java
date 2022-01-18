package uz.ruzyume.porfolio_block.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.ruzyume.porfolio_block.domain._Contact;
import uz.ruzyume.porfolio_block.model.ContactDto;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

public interface ContactRepository extends JpaRepository<_Contact, Long> {

     Optional<_Contact> findByIdAndDeletedFalse(@NotNull final Long id);

     List<_Contact> findAllByDeletedFalse();

}
