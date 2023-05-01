package andresgois.github.io.criptografiasenhausuario.service;

import andresgois.github.io.criptografiasenhausuario.data.DetalheUsuarioData;
import andresgois.github.io.criptografiasenhausuario.model.Usuario;
import andresgois.github.io.criptografiasenhausuario.repository.UsuarioRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import java.util.Optional;

@Component
public class DetalheUsuarioServiceImpl implements UserDetailsService {

    private final UsuarioRepository repository;

    public DetalheUsuarioServiceImpl(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> usuario = repository.findByLogin(username);
        if(usuario.isEmpty()){
            throw new UsernameNotFoundException("Usuário ["+username+"] não encontrado!");
        }
        return new DetalheUsuarioData(usuario);
    }
}
