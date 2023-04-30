package andresgois.github.io.criptografiasenhausuario.controller;

import andresgois.github.io.criptografiasenhausuario.model.Usuario;
import andresgois.github.io.criptografiasenhausuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    private final UsuarioRepository usuarioRepository;

    @Autowired
    private final PasswordEncoder encoder;

    public UsuarioController(UsuarioRepository usuarioRepository, PasswordEncoder encoder) {
        this.usuarioRepository = usuarioRepository;
        this.encoder = encoder;
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listAllUsers(){
        return ResponseEntity.ok(usuarioRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Usuario> salvar(@RequestBody Usuario user){
        user.setPassword(encoder.encode(user.getPassword()));
        return ResponseEntity.ok(usuarioRepository.save(user));
    }

    @GetMapping("/validaSenha")
    public ResponseEntity<Boolean> validaSenha(@RequestParam String login,
                                                     @RequestParam String password){

        Optional<Usuario> optUser = usuarioRepository.findByLogin(login);
        if(optUser.isEmpty()){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
        }
        Usuario u = optUser.get();
        boolean valid = encoder.matches(password, u.getPassword());
        HttpStatus status = (valid) ? HttpStatus.OK : HttpStatus.UNAUTHORIZED;
        return ResponseEntity.status(status).body(valid);
    }

}
