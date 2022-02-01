package uz.ruzyume.porfolio_block.controller;

import lombok.NonNull;
import org.springframework.web.bind.annotation.*;
import uz.ruzyume.porfolio_block.model.AboutMeDto;
import uz.ruzyume.porfolio_block.model.GenericDto;
import uz.ruzyume.porfolio_block.model.create.AboutMeCreateDto;
import uz.ruzyume.porfolio_block.model.update.AboutMeUpdateDto;
import uz.ruzyume.porfolio_block.service.AboutMeService;

import java.util.List;

@RestController
@RequestMapping("/api/about-me/v1")
public class AboutMeController {
    private final AboutMeService service;

    public AboutMeController(AboutMeService service) {
        this.service = service;
    }

    @PostMapping("/create")
    private GenericDto create(@RequestBody final AboutMeCreateDto createDto){
        return service.create(createDto);
    }
    @PutMapping("/update/id/{id}")
    private AboutMeDto update(@NonNull final AboutMeUpdateDto updateDto, @RequestParam(value = "id") final Long id){
        return service.update(updateDto, id);
    }
    @GetMapping("/get/id/{id}")
    private AboutMeDto getById(@RequestParam(value = "id")final Long id){
        return service.getById(id);
    }
    @GetMapping("/geAll")
    private List<AboutMeDto> getAll(){
        return service.getAll();
    }
    @DeleteMapping("/delete/id/{id}")
    private Boolean delete(@RequestParam(value = "id")final Long id){
        return service.delete(id);
    }
}
