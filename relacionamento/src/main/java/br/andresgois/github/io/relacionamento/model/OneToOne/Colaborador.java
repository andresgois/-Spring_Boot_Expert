package br.andresgois.github.io.relacionamento.model.OneToOne;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "colaboradores")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Colaborador {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    
    private String nome;
    
    /**
     * name = nome do campo que será gerado na tabela colaborador
     * referencedColumnName = campo que esta sendo referenciado da tabela cargo
     */
    @OneToOne // Vinculo entre colaborador e a entidade cargo
    @JoinColumn(name = "codigo_cargo", referencedColumnName = "codigo")
    private Cargo cargo;
}
