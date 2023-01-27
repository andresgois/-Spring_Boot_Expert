package io.gtihub.andresgois.domain.entity;

import javax.persistence.*;

@Entity
//@Table(name = "cliente")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nome")
    private String nome;

    public Client(){}

    public Client(String nome) {
        this.nome = nome;
    }

    public Client(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
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

    @Override
    public String toString() {
        return "ClienteTeste{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
