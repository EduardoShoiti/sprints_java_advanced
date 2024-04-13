package br.com.fiap.previsaoSafra.controller;

import br.com.fiap.previsaoSafra.service.ColheitaService;
import br.com.fiap.previsaoSafra.service.DadosProducaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dadosproducao")
public class DadosProducaoController {

    private final DadosProducaoService dadosProducaoService;

    @Autowired
    public DadosProducaoController(DadosProducaoService dadosProducaoService) { this.dadosProducaoService = dadosProducaoService; }
}
