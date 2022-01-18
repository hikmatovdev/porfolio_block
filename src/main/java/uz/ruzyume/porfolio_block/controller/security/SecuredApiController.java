package uz.ruzyume.porfolio_block.controller.security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/secured/v1")
public class SecuredApiController {
    @GetMapping
    String get(){
        return "You have been passed successfully";
    }
}
