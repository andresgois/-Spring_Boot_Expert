package io.gtihub.andresgois.security.jwt;

import io.gtihub.andresgois.VendasApplication;
import io.gtihub.andresgois.domain.entity.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;

@Service
public class JwtService {

    @Value("${security.jwt.expiracao}")
    private String expiracao;

    @Value("${security.jwt.chave-assinatura}")
    private String chaveAssinatura;

    public String gerarToken(Usuario usuario){
        long expString = Long.valueOf(expiracao);
        LocalDateTime dataHoraExpiracao = LocalDateTime.now()
                .plusMinutes(expString);
        Instant instant = dataHoraExpiracao.atZone(ZoneId.systemDefault()).toInstant();
        Date data = Date.from(instant);

        HashMap<String, Object> claims = new HashMap<>();
        claims.put("email", "testa@email.com");
        claims.put("roles", "admin");

        return Jwts
                .builder()
                .setSubject(usuario.getLogin())
                .setExpiration(data)
                //.setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, chaveAssinatura)
                .compact();
    }

    public static void main(String[] args){
        ConfigurableApplicationContext context = SpringApplication.run(VendasApplication.class);
        JwtService service = context.getBean(JwtService.class);
        Usuario usuario = Usuario.builder().login("fulano").build();
        String token = service.gerarToken(usuario);
        System.out.println("------------ TOKEN -------------");
        System.out.println(token);
        System.out.println("------------ TOKEN VALIDO -------------");
        boolean isTokenValido = service.tokenValido(token);
        System.out.println("O Token está válido: "+isTokenValido);

        System.out.println("------------ Usuario logado -------------");
        System.out.println(service.obterLoginUsuario(token));
    }

    private Claims obterClaims(String token ) throws ExpiredJwtException {

        return Jwts
                .parser()
                .setSigningKey(chaveAssinatura)
                .parseClaimsJws(token)
                .getBody();
    }

    public boolean tokenValido(String token){
        try {
            Claims claims = obterClaims(token);
            Date dataExpiracao = claims.getExpiration();

            LocalDateTime data =
                    dataExpiracao.toInstant()
                            .atZone(ZoneId.systemDefault()).toLocalDateTime();
            // verifica se a data atual é depois da expiração do token
            return !LocalDateTime.now().isAfter(data);

        } catch (Exception e){
            return false;
        }
    }

    public String obterLoginUsuario(String token)  throws ExpiredJwtException{
        return (String) obterClaims(token).getSubject();
    }
}
