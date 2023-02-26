package io.github.andresgois.localizacao.domain.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_cidade")
@Data
public class Cidade {

    @Id
    @Column(name = "id_cidade")
    private Long id;
    @Column(name = "nome", length = 50)
    private String nome;
    @Column(name = "qtd_habitante")
    private String habitante;
    
}
