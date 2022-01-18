package uz.ruzyume.porfolio_block.controller;

import lombok.NonNull;
import org.springframework.web.bind.annotation.*;
import uz.ruzyume.porfolio_block.model.GenericDto;
import uz.ruzyume.porfolio_block.model.LanguageDto;
import uz.ruzyume.porfolio_block.model.create.LanguageCreateDto;
import uz.ruzyume.porfolio_block.model.update.LanguageUpdateDto;
import uz.ruzyume.porfolio_block.service.LanguageService;
import java.util.List;

@RestController
@RequestMapping("/api/language/v1")
public class LanguageController {
    private final LanguageService languageService;

    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }
    @PostMapping("/create")
    private GenericDto create(@NonNull final LanguageCreateDto createDto){
        return languageService.create(createDto);
    }
    @PutMapping("/update/id/{id}")
    private LanguageDto update(@NonNull final LanguageUpdateDto updateDto, @RequestParam(value = "id") final Long id){
        return languageService.update(updateDto, id);
    }
    @DeleteMapping("/delete/id/{id}")
    private Boolean delete(@RequestParam(value = "id")final Long id){
        return languageService.delete(id);
    }
    @GetMapping("/getAll")
    private List<LanguageDto> getAll(){
        return languageService.getAll();
    }
    @GetMapping("get/id/{id}")
    private LanguageDto get(@RequestParam(value = "id")final Long id){
        return languageService.get(id);
    }

}
