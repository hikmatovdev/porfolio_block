package uz.ruzyume.porfolio_block.controller.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.ruzyume.porfolio_block.config.UserSession;

@RestController
@RequestMapping("api/secured/v1")
public class SecuredApiController {
    @GetMapping("/user")
    User get(){
     return UserSession.currentUser();
    }
}
