package br.andresgois.github.io.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import br.andresgois.github.io.domain.Categoria;

public class CategoriaDTO implements Serializable{
    
    private static final long serialVersionUID = 1L;
    private Integer id;
    @NotEmpty(message = "Campo nome é requerido")
    @Length(min = 3, max = 200, message = "O campo nome deve ter entre 3 e 200 caracteres")
    private String nome;
    
    @NotEmpty(message = "descrição nome é requerido")
    @Length(min = 3, max = 200, message = "O campo descrição deve ter entre 3 e 200 caracteres")
    private String descricao;
    
    public CategoriaDTO() {}
    
    public CategoriaDTO(Categoria c) {
        super();
        this.id = c.getId();
        this.nome = c.getNome();
        this.descricao = c.getDescricao();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
}
