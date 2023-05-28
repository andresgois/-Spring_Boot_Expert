package io.github.andresgois.mscartoes.service;

import io.github.andresgois.mscartoes.domain.Cartao;
import io.github.andresgois.mscartoes.infra.repository.CartoesRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CartaoService {

    private final CartoesRepository cartoesRepository;

    @Transactional
    public Cartao save(Cartao cartao){
        log.info("Cartão ->>> {}", cartao);
        return cartoesRepository.save(cartao);
    }

    public List<Cartao> getCartoesRendaMenorIgual(Long renda){
        var rendaBigDecimal = BigDecimal.valueOf(renda);
        return cartoesRepository.findByRendaLessThanEqual(rendaBigDecimal);
    }
}
