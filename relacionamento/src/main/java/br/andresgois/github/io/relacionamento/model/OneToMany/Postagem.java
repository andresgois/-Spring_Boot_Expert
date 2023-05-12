package br.andresgois.github.io.relacionamento.model.OneToMany;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "postagens")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Postagem {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private String titulo;
    private String texto;
    
    @OneToMany
    @JoinColumn(name = "codigo_postagem")
    private List<Comentario> comentario;
}
