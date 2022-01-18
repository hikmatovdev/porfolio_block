package uz.ruzyume.porfolio_block.controller.security;

import org.springframework.web.bind.annotation.*;
import uz.ruzyume.porfolio_block.model.security.LoginDto;
import uz.ruzyume.porfolio_block.service.securtiy.AuthService;

@RestController
@RequestMapping("api/permitted/v1")
public class PermittedController {

    private final AuthService authService;

    public PermittedController(AuthService authService) {
        this.authService = authService;
    }


    @GetMapping
        String get(){
            return "It is unsecure API!";
        }
        @PostMapping("/login")
    String login(@RequestBody final LoginDto dto){
            return authService.login(dto);
        }
}
