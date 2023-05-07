package br.andresgois.github.io.dtos;

import java.io.Serializable;

import br.andresgois.github.io.domain.Livro;

public class LivroDTO implements Serializable{
    
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String titulo;
    private String nome_aut;
    private String texto;
    
    public LivroDTO() {}

    public LivroDTO(Livro liv) {
        super();
        this.id = liv.getId();
        this.titulo = liv.getTitulo();
        this.nome_aut = liv.getNome_aut();
        this.texto = liv.getTexto();
    }

    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNome_aut() {
        return nome_aut;
    }

    public void setNome_aut(String nome_aut) {
        this.nome_aut = nome_aut;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }
    
    
    
}
