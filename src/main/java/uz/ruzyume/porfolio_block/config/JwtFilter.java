package uz.ruzyume.porfolio_block.config;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import uz.ruzyume.porfolio_block.provider.JwtProvider;
import uz.ruzyume.porfolio_block.service.securtiy.UserService;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtFilter extends OncePerRequestFilter {
    private final JwtProvider jwtProvider;
    private final UserService userService;

    public JwtFilter(JwtProvider jwtProvider, UserService userService) {
        this.jwtProvider = jwtProvider;
        this.userService = userService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = (request.getHeader("Authorization"));
        if (StringUtils.hasText(token) && token.startsWith("Bearer")){
            token = token.substring(7);
           boolean isValidate = jwtProvider.validateToken(token);
        if (isValidate){
           String username = jwtProvider.getUsername(token);
            UserDetails user = userService.loadUserByUsername(username);

            SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities()));

        }
        }

    }
}
