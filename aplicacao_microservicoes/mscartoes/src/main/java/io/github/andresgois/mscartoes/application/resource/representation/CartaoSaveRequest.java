package io.github.andresgois.mscartoes.application.resource.representation;

import io.github.andresgois.mscartoes.domain.Cartao;
import io.github.andresgois.mscartoes.enumerated.BandeiraCartao;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;

@Data
public class CartaoSaveRequest {

    private String nome;
    private BandeiraCartao bandeira;
    private BigDecimal renda;
    private BigDecimal limite;

    public Cartao toModel(){
        return new Cartao(nome, bandeira, renda, limite);
    }
}
