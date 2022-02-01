package uz.ruzyume.porfolio_block.controller.security;

import org.springframework.web.bind.annotation.*;
import uz.ruzyume.porfolio_block.model.security.LoginDto;
import uz.ruzyume.porfolio_block.service.securtiy.AuthService;

@RestController
@RequestMapping("api/auth/v1")
public class AuthV1Controller {

    private final AuthService authService;

    public AuthV1Controller(AuthService authService) {
        this.authService = authService;
    }


        @PostMapping("/login")
        String login(@RequestBody final LoginDto dto){
            return authService.login(dto);
        }
}
