package andresgois.github.io.criptografiasenhausuario.controller;

import andresgois.github.io.criptografiasenhausuario.model.Usuario;
import andresgois.github.io.criptografiasenhausuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    private final UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listAllUsers(){
        return ResponseEntity.ok(usuarioRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Usuario> salvar(@RequestBody Usuario user){
        return ResponseEntity.ok(usuarioRepository.save(user));
    }

}
