package uz.ruzyume.porfolio_block.service;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import uz.ruzyume.porfolio_block.domain._AboutMe;
import uz.ruzyume.porfolio_block.exception.NotFoundException;
import uz.ruzyume.porfolio_block.model.AboutMeDto;
import uz.ruzyume.porfolio_block.model.GenericDto;
import uz.ruzyume.porfolio_block.model.create.AboutMeCreateDto;
import uz.ruzyume.porfolio_block.model.update.AboutMeUpdateDto;
import uz.ruzyume.porfolio_block.repository.AboutMeRepository;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class AboutMeService {

    private final AboutMeRepository aboutMeRepository;
    private final ObjectMapper objectMapper;

    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    Validator validator = factory.getValidator();


    public AboutMeService(AboutMeRepository aboutMeRepository, ObjectMapper objectMapper) {
        this.aboutMeRepository = aboutMeRepository;
        this.objectMapper = objectMapper;
    }
    public GenericDto create(final AboutMeCreateDto createDto){
        Set<ConstraintViolation<AboutMeCreateDto>> violations = validator.validate(createDto);
        StringBuilder stringBuilder = new StringBuilder();
        if (violations.size() > 1){
            violations.forEach(validateError -> stringBuilder.append(validateError.getMessage()));
            throw new RuntimeException(stringBuilder.toString());
        }
        _AboutMe aboutMe = _AboutMe.builder()
                .aboutMe(createDto.getAboutMe())
                .build();
        Long id = aboutMeRepository.save(aboutMe).getId();

        return GenericDto.builder().id(id).build();
    }
    public AboutMeDto update(final AboutMeUpdateDto updateDto, final Long id){
        Optional<_AboutMe> aboutMeOptional = aboutMeRepository.findByIdAndDeletedFalse(id);
        if (aboutMeOptional.isPresent()){
            _AboutMe aboutMeToUpdate = aboutMeOptional.get();
            objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            try {
                objectMapper.updateValue(aboutMeToUpdate, updateDto);
            } catch (JsonMappingException e) {
               throw new RuntimeException("Update qilib bo'lmadi!");
            }
            _AboutMe aboutMeUpdated = aboutMeRepository.save(aboutMeToUpdate);
            return objectMapper.convertValue(aboutMeUpdated, AboutMeDto.class);
        }
        throw new NotFoundException("Bunday id bilan ma'lumot topilmadi!");
    }
    public AboutMeDto getById(final Long id){
        Optional<_AboutMe> aboutMeOptional =  aboutMeRepository.findByIdAndDeletedFalse(id);
        if (aboutMeOptional.isPresent()){
            return objectMapper.convertValue(aboutMeOptional.get(), AboutMeDto.class);
        }
        throw new NotFoundException("Bunday id bilan ma'lumot topilmadi");
    }
    public List<AboutMeDto> getAll(){
        return objectMapper.convertValue(aboutMeRepository.findAllByDeletedFalse(), new TypeReference<>() {
        });
    }
    public Boolean delete(final Long id){
        Optional<_AboutMe> aboutMeOptional = aboutMeRepository.findByIdAndDeletedFalse(id);
        if (aboutMeOptional.isPresent()){
           _AboutMe aboutMe = aboutMeOptional.get();
           aboutMe.setDeleted(true);
           aboutMeRepository.save(aboutMe);
           return true;
        }
        throw new NotFoundException("Bunday id bilan ma'lumot topilmadi!");
    }

}
