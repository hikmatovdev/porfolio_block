package uz.ruzyume.porfolio_block.controller;

import org.springframework.web.bind.annotation.*;
import uz.ruzyume.porfolio_block.model.ContactDto;
import uz.ruzyume.porfolio_block.model.GenericDto;
import uz.ruzyume.porfolio_block.model.create.ContactCreateDto;
import uz.ruzyume.porfolio_block.model.update.ContactUpdateDto;
import uz.ruzyume.porfolio_block.service.ContactService;

import java.util.List;

@RestController
@RequestMapping("/api/contact/v1")
public class ContactController {

    private final ContactService contactService;


    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping
    private GenericDto create(@RequestBody final ContactCreateDto createDto){
        return contactService.create(createDto);
    }
    @PutMapping("update/id/{id}")
    private ContactDto update(@RequestBody final ContactUpdateDto updateDto, @RequestParam(value = "id") final Long id){
        return contactService.update(updateDto, id);
    }
    @GetMapping("get/id/{id}")
    private ContactDto get(@RequestParam(value = "id")final Long id){
        return contactService.get(id);
    }
    @GetMapping
    private List<ContactDto> getAll(){
        return contactService.getAll();
    }
    @DeleteMapping("/delete/id/{id}")
    private Boolean delete(@RequestParam(value = "id")final Long id){
        return contactService.delete(id);
    }
}
