package uz.ruzyume.porfolio_block.controller;

import lombok.NonNull;
import org.springframework.web.bind.annotation.*;
import uz.ruzyume.porfolio_block.model.EducationDto;
import uz.ruzyume.porfolio_block.model.GenericDto;
import uz.ruzyume.porfolio_block.model.create.EducationCreateDto;
import uz.ruzyume.porfolio_block.model.update.EducationUpdateDto;
import uz.ruzyume.porfolio_block.service.EducationService;

import java.util.List;

@RestController
@RequestMapping("api/education/v1")
public class EducationController {

    private final EducationService educationService;

    public EducationController(EducationService educationService) {
        this.educationService = educationService;
    }
    @PostMapping("/create")
    private GenericDto create(@NonNull final EducationCreateDto createDto){
        return educationService.create(createDto);
    }
    @PutMapping("/update/id/{id}")
    private EducationDto update(@NonNull final EducationUpdateDto updateDto, @RequestParam(value = "id")final Long id){
        return educationService.update(updateDto, id);
    }
    @GetMapping("getById/id/{id}")
        private EducationDto getById(@RequestParam(value = "id")final Long id){
        return educationService.getById(id);
    }
    @GetMapping("/getAll")
    private List<EducationDto> getAll(){
        return educationService.getAll();
    }
    @DeleteMapping("/delete/id/{id}")
    private Boolean delete(@RequestParam(value = "id")final Long id){
        return educationService.delete(id);
    }
}
