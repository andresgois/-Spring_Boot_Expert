package io.gtihub.andresgois.domain.entity;

//@Table(name = "cliente_teste")
class ClienteTeste {

    private Integer id;
    private String nome;

    public ClienteTeste(){}

    public ClienteTeste(String nome) {
        this.nome = nome;
    }

    public ClienteTeste(Integer id, String nome) {
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
