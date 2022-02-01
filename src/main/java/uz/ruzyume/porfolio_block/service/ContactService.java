package uz.ruzyume.porfolio_block.service;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NonNull;
import org.springframework.stereotype.Service;
import uz.ruzyume.porfolio_block.domain._Contact;
import uz.ruzyume.porfolio_block.exception.NotFoundException;
import uz.ruzyume.porfolio_block.model.ContactDto;
import uz.ruzyume.porfolio_block.model.GenericDto;
import uz.ruzyume.porfolio_block.model.create.ContactCreateDto;
import uz.ruzyume.porfolio_block.model.update.ContactUpdateDto;
import uz.ruzyume.porfolio_block.repository.ContactRepository;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ContactService {

    private final ContactRepository contactRepository;
    private final ObjectMapper objectMapper;

     ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
     Validator validator = factory.getValidator();


    public ContactService(ContactRepository contactRepository, ObjectMapper objectMapper) {
        this.contactRepository = contactRepository;
        this.objectMapper = objectMapper;
    }
    public GenericDto create(@NonNull final ContactCreateDto createDto){
        Set<ConstraintViolation<ContactCreateDto>> violations = validator.validate(createDto);
        StringBuilder stringBuilder = new StringBuilder();
        if (violations.size() > 1){
             violations.forEach(validateError -> stringBuilder.append(validateError.getMessage()));
             throw new RuntimeException(stringBuilder.toString());
        }
        _Contact contact = _Contact.builder()
                .contact(createDto.getContact())
                .contactName(createDto.getContactName())
                .build();
        Long id = contactRepository.save(contact).getId();

        return GenericDto.builder().id(id).build();
    }
    public ContactDto update(@NonNull final ContactUpdateDto updateDto, @NonNull final Long id){
       Optional<_Contact> contactOptional = contactRepository.findByIdAndDeletedFalse(id);
       if (contactOptional.isPresent()){
           _Contact contactToUpdated = contactOptional.get();
           objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
           try {
               objectMapper.updateValue(contactToUpdated, updateDto);
           } catch (JsonMappingException e) {
               throw new RuntimeException("Update qilib bo'lmadi!");
           }
           _Contact contactUpdated = contactRepository.save(contactToUpdated);
           return objectMapper.convertValue(contactUpdated, ContactDto.class);
       }
       throw new NotFoundException("Bunday id bilan contact topilmadi!");
    }
    public ContactDto get(@NonNull final Long id){
        Optional<_Contact> contactOptional = contactRepository.findByIdAndDeletedFalse(id);
        if (contactOptional.isPresent()){
            _Contact contact = contactOptional.get();
            return objectMapper.convertValue(contact, ContactDto.class);
        }
        throw new NotFoundException("Bunday id bilan contact topilmadi!");
    }
    public List<ContactDto> getAll(){
        List<_Contact> contactList = contactRepository.findAllByDeletedFalse();
        return objectMapper.convertValue(contactList, new TypeReference<>() {
        });
    }
    public Boolean delete(@NonNull final Long id){
        Optional<_Contact> contactOptional = contactRepository.findByIdAndDeletedFalse(id);
        if (contactOptional.isPresent()){
            _Contact contactToDeleted = contactOptional.get();
           contactToDeleted.setDeleted(true);
           contactRepository.save(contactToDeleted);
           return true;
        }
        throw new NotFoundException("Bunday id bilan contact topilmadi!");
    }
}
