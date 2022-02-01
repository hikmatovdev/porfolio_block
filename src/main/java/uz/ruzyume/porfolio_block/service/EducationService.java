package uz.ruzyume.porfolio_block.service;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NonNull;
import org.springframework.stereotype.Service;
import uz.ruzyume.porfolio_block.domain._Education;
import uz.ruzyume.porfolio_block.exception.NotFoundException;
import uz.ruzyume.porfolio_block.model.EducationDto;
import uz.ruzyume.porfolio_block.model.GenericDto;
import uz.ruzyume.porfolio_block.model.create.EducationCreateDto;
import uz.ruzyume.porfolio_block.model.update.EducationUpdateDto;
import uz.ruzyume.porfolio_block.repository.EducationRepository;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
public class EducationService {
    private final EducationRepository educationRepository;
    private final ObjectMapper objectMapper;

    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    Validator validator = factory.getValidator();

    public EducationService(EducationRepository educationRepository, ObjectMapper objectMapper) {
        this.educationRepository = educationRepository;
        this.objectMapper = objectMapper;
    }
    public GenericDto create(@NonNull final EducationCreateDto createDto){
        Set<ConstraintViolation<EducationCreateDto> > violations = validator.validate(createDto);
        StringBuilder stringBuilder = new StringBuilder();
        if(violations.size() > 1){
            violations.forEach(validateError -> stringBuilder.append(validateError.getMessage()));
            throw new RuntimeException(stringBuilder.toString());
        }
        _Education education = _Education.builder()
                .educatorName(createDto.getEducatorName())
                .specialization(createDto.getSpecialization())
                .year(createDto.getYear())
                .build();
       Long id =  educationRepository.save(education).getId();
       return GenericDto.builder().id(id).build();
    }
    public EducationDto update(@NonNull final EducationUpdateDto updateDto, @NonNull final Long id)  {
        Optional<_Education> educationOptional = educationRepository.findByIdAndDeletedFalse(id);
        if (educationOptional.isPresent()){
            _Education educationToUpdate = educationOptional.get();
            objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            try {
                objectMapper.updateValue(educationToUpdate, updateDto);
            } catch (JsonMappingException e) {
                throw new RuntimeException("Update qilib bo'lmadi!");
            }
            _Education educationUpdated = educationRepository.save(educationToUpdate);
            return  objectMapper.convertValue(educationUpdated, EducationDto.class);
        }
        throw new NotFoundException("Bunday id bilan ma'lumot topilmadi!");
    }
    public EducationDto getById(@NonNull final Long id){
        Optional<_Education> educationOptional = educationRepository.findByIdAndDeletedFalse(id);
        if (educationOptional.isPresent()){
            _Education education = educationOptional.get();
            return objectMapper.convertValue(education, EducationDto.class);
        }
        throw new NotFoundException("Bunday id bilan ma'lumot topilmadi!");
    }
    public List<EducationDto> getAll(){
        return objectMapper.convertValue(educationRepository.findAllByDeletedFalse(), new TypeReference<>() {
        });
    }
    public Boolean delete(@NonNull final Long id){
        Optional<_Education> educationOptional = educationRepository.findByIdAndDeletedFalse(id);
        if (educationOptional.isPresent()){
            _Education education = educationOptional.get();
            education.setDeleted(true);
            educationRepository.save(education);
            return true;
        }
        throw new NotFoundException("Bunday id bilan ma'lumot topilmadi!");
    }
}
