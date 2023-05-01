package andresgois.github.io.criptografiasenhausuario.data;

import andresgois.github.io.criptografiasenhausuario.model.Usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

public class DetalheUsuarioData implements UserDetails {

    private final Optional<Usuario> optuser;

    public DetalheUsuarioData(Optional<Usuario> optuser) {
        this.optuser = optuser;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<>();
    }

    @Override
    public String getPassword() {
        return optuser.orElse(new Usuario()).getPassword();
    }

    @Override
    public String getUsername() {
        return optuser.orElse(new Usuario()).getLogin();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
