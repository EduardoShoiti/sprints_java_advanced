package br.com.fiap.previsaoSafra.controller;

import br.com.fiap.previsaoSafra.controller.dto.DadosProducaoDTO;
import br.com.fiap.previsaoSafra.model.DadosProducao;
import br.com.fiap.previsaoSafra.service.DadosProducaoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dadosproducao")
public class DadosProducaoController {
    private final DadosProducaoService dadosProducaoService;
    @Autowired
    public DadosProducaoController(DadosProducaoService dadosProducaoService) {this.dadosProducaoService = dadosProducaoService; }
    


}
