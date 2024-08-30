package com.senac.daniela.gerenciamentosalas.services;


import com.senac.daniela.gerenciamentosalas.repository.DiasSemAlocacaoRepository;
import org.springframework.stereotype.Service;

@Service
public class DiasSemAlocacaoService {

    private final DiasSemAlocacaoRepository diasSemAlocacaoRepository;

    public DiasSemAlocacaoService(DiasSemAlocacaoRepository diasSemAlocacaoRepository) {
        this.diasSemAlocacaoRepository = diasSemAlocacaoRepository;
    }


}
