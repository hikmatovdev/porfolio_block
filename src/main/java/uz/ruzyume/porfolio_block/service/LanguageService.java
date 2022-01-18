package uz.ruzyume.porfolio_block.service;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NonNull;
import org.springframework.stereotype.Service;
import uz.ruzyume.porfolio_block.domain._Language;
import uz.ruzyume.porfolio_block.model.GenericDto;
import uz.ruzyume.porfolio_block.model.LanguageDto;
import uz.ruzyume.porfolio_block.model.create.LanguageCreateDto;
import uz.ruzyume.porfolio_block.model.update.LanguageUpdateDto;
import uz.ruzyume.porfolio_block.repository.LanguageRepository;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class LanguageService {

    private final LanguageRepository languageRepository;
    private final ObjectMapper objectMapper;

    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    Validator validator = factory.getValidator();

    public LanguageService(LanguageRepository languageRepository, ObjectMapper objectMapper) {
        this.languageRepository = languageRepository;
        this.objectMapper = objectMapper;
    }
    public GenericDto create(@NonNull final LanguageCreateDto createDto){
        Set<ConstraintViolation<LanguageCreateDto>> violations = validator.validate(createDto);
        if (violations.size() > 1){
            StringBuilder stringBuilder = new StringBuilder();
            violations.forEach(validateError -> {
                stringBuilder.append(validateError.getMessage());
            });
            throw new RuntimeException(stringBuilder.toString());
        }
        _Language language = _Language.builder()
                .language(createDto.getLanguage())
                .level(createDto.getLevel())
                .build();
        Long id = languageRepository.save(language).getId();
        return GenericDto.builder().id(id).build();
    }
    public LanguageDto update(@NonNull final LanguageUpdateDto updateDto, @NonNull final Long id){
        Optional<_Language> languageOptional = languageRepository.findByIdAndDeletedFalse(id);
        if (languageOptional.isPresent()){
            _Language languageToUpdate = languageOptional.get();
            objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            try {
                objectMapper.updateValue(languageToUpdate, updateDto);
            } catch (JsonMappingException e) {
                throw new RuntimeException("Update qilib bo'lmadi!");
            }
            _Language languageUpdated = languageRepository.save(languageToUpdate);
            return objectMapper.convertValue(languageUpdated, LanguageDto.class);
        }
        throw new RuntimeException("Bunday id bilan [language] topilmadi!");
    }
    public Boolean delete(@NonNull final Long id){
        Optional<_Language> languageOptional = languageRepository.findByIdAndDeletedFalse(id);
        if (languageOptional.isPresent()){
            _Language language = languageOptional.get();
            language.setDeleted(true);
            languageRepository.save(language);
          return true;
        }
        throw new RuntimeException("Bunday id bilan [language topilmadi!]");
    }
    public List<LanguageDto> getAll(){
        List<_Language> languageList = languageRepository.findAllByDeletedFalse();
        return objectMapper.convertValue(languageList, new TypeReference<>() {
        });
    }
    public LanguageDto get(@NonNull final Long id){
        Optional<_Language> languageOptional = languageRepository.findByIdAndDeletedFalse(id);
        if (languageOptional.isPresent()){
            return objectMapper.convertValue(languageOptional.get(), LanguageDto.class);
        }
        throw new RuntimeException("Bunday id bilan [language] topilmadi!");
    }
}
