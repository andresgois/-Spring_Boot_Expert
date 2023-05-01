package andresgois.github.io.criptografiasenhausuario.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class JWTValidarFIlter extends BasicAuthenticationFilter {

    public static final String HEADER_ATT = "Authorization";
    public static final String ATT_PREF = "Bearer ";
    public JWTValidarFIlter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws IOException, ServletException {

        String atributo = request.getHeader(HEADER_ATT);

        if( atributo == null){
            chain.doFilter(request, response);
            return;
        }

        if( !atributo.startsWith(ATT_PREF)){
            chain.doFilter(request, response);
            return;
        }
        String token = atributo.replace(ATT_PREF, "");
        UsernamePasswordAuthenticationToken authenticationToken = getAuthentication(token);

        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        chain.doFilter(request, response);
    }

    private UsernamePasswordAuthenticationToken getAuthentication(String token){
        String usuario = JWT.require(Algorithm.HMAC512(JWTAutenticarFiltro.TOKEN_LOGIN))
                .build()
                .verify(token)
                .getSubject();
        if( usuario == null){
            return null;
        }

        return new UsernamePasswordAuthenticationToken(usuario, null, new ArrayList<>());
    }
}
