package uz.ruzyume.porfolio_block.controller.security;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.ruzyume.porfolio_block.model.GenericDto;
import uz.ruzyume.porfolio_block.model.security.user.UserAddDto;
import uz.ruzyume.porfolio_block.service.securtiy.UserService;

@RestController
@RequestMapping("api/user/v1")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //@PreAuthorize(value = "hasAuthority('USER_ADD')")
    @PostMapping
    private GenericDto add(@RequestBody final UserAddDto addDto){
        return userService.add(addDto);
    }
}
