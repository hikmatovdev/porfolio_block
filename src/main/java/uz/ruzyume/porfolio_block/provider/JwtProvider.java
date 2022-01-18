package uz.ruzyume.porfolio_block.provider;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtProvider {
    private final String privateKey = "password";

    public  String generateToken(final String username){
        final   long availableTime = 1000*60*30;
        return Jwts
                .builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+availableTime))
                .signWith(SignatureAlgorithm.HS512, privateKey)
                .compact();
    }
    public boolean validateToken(final String token){

       try {
           Jwts
                   .parser()
                   .setSigningKey(privateKey)
                   .parseClaimsJws(token);
       }catch (Exception e){
           throw new RuntimeException(e.getMessage());
       }
       return true;
    }
    public String getUsername(final String token){
       return Jwts.
                parser()
                .setSigningKey(privateKey)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }


}
