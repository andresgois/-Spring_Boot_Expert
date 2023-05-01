package br.andresgois.github.io.domain;

import java.util.Objects;

public class Livro {
    
    private Integer id;
    private String titulo;
    private String nome_aut;
    private String texto;
    
    private Categoria categoria;

    public Livro() {}
    
    public Livro(Integer id, String titulo, String nome_aut, String texto, Categoria categoria) {
        super();
        this.id = id;
        this.titulo = titulo;
        this.nome_aut = nome_aut;
        this.texto = texto;
        this.categoria = categoria;
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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Livro other = (Livro) obj;
        return Objects.equals(id, other.id);
    }
    
    
    
}
