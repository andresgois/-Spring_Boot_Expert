package io.gtihub.andresgois.domain.entity;

public class Cliente {

    private Integer id;
    private String nome;

    public Cliente(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
