package andresgois.github.io.criptografiasenhausuario.repository;

import andresgois.github.io.criptografiasenhausuario.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    public Optional<Usuario> findByLogin(String login);

}
