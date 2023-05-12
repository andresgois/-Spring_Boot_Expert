package br.andresgois.github.io.relacionamento.model.ManyToMany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "alunos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Aluno {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private String aluno;
    
    @JsonIgnore
    @ManyToMany
    @JoinTable(
        name = "tabela_auxiliar",
        joinColumns = { @JoinColumn(name = "cod_aluno", referencedColumnName = "codigo")},
        inverseJoinColumns = {@JoinColumn(name = "cod_curso", referencedColumnName = "codigo")}
    )
    private List<Curso> cursos = new ArrayList<>();
    
}
