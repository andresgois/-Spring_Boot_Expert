package br.andresgois.github.io.dtos;

import java.io.Serializable;
import br.andresgois.github.io.domain.Categoria;

public class CategoriaDTO implements Serializable{
    
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String nome;
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
