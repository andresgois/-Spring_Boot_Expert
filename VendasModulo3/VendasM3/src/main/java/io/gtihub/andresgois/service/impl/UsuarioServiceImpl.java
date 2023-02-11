package io.gtihub.andresgois.service.impl;

import io.gtihub.andresgois.domain.entity.Usuario;
import io.gtihub.andresgois.domain.repository.IUsuarioRepository;
import io.gtihub.andresgois.exception.SenhaInvalidaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioServiceImpl implements UserDetailsService {

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Transactional
    public Usuario salvar(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public UserDetails autenticar(Usuario usuario){
        UserDetails user = loadUserByUsername(usuario.getLogin());
        boolean senhasBatem = encoder.matches(usuario.getSenha(), user.getPassword());
        if(senhasBatem){
            return  user;
        }

        throw new SenhaInvalidaException();
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        /*if(!username.equals("cicrano")){
            throw new UsernameNotFoundException("Usuário não encontrado!");
        }
        return User
                .builder()
                .username("cicrano")
                .password(encoder.encode("123"))
                .roles("USER","ADMIN")
                .build();*/


        Usuario usuario = usuarioRepository.findByLogin(username).orElseThrow(
                () -> new UsernameNotFoundException("Usuário não encontrado!"));
        String[] roles = usuario.isAdmin() ?
                new String[] {"ADMIN", "USER"} : new String[]{"USER"};

        return User
                .builder()
                .username(usuario.getLogin())
                .password(usuario.getSenha())
                .roles(roles)
                .build();
    }
}
