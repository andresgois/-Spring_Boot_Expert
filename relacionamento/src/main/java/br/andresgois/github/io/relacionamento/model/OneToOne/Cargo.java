package br.andresgois.github.io.relacionamento.model.OneToOne;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cargos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cargo {
   /**
    * Colaborador pecisa ter um cargo que está nessa tabela 
    */
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private String cargo;
    private double salario;
    
}
