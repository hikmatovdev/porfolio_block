package uz.ruzyume.porfolio_block.service.securtiy;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import uz.ruzyume.porfolio_block.model.security.LoginDto;
import uz.ruzyume.porfolio_block.provider.JwtProvider;

@Service
public class AuthService  {
    private  final JwtProvider jwtProvider;
    private final AuthenticationManager authenticationManager;

    public AuthService( JwtProvider jwtProvider, AuthenticationManager authenticationManager) {
        this.jwtProvider = jwtProvider;
        this.authenticationManager = authenticationManager;
    }
    public String login(final LoginDto loginDto){

    try {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword()));
    }catch (BadCredentialsException e){
        throw new RuntimeException("Login or password is incorrect!");
    }
    return jwtProvider.generateToken(loginDto.getUsername());
    }



}





