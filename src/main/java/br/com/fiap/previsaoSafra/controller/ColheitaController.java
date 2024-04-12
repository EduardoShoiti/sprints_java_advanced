package br.com.fiap.previsaoSafra.controller;

import br.com.fiap.previsaoSafra.model.Colheita;
import br.com.fiap.previsaoSafra.model.Fazenda;
import br.com.fiap.previsaoSafra.repository.ColheitaRepository;
import br.com.fiap.previsaoSafra.service.ColheitaService;
import br.com.fiap.previsaoSafra.service.FazendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/colheita")
public class ColheitaController {
    private final ColheitaService colheitaService;

    @Autowired
    public ColheitaController(ColheitaService colheitaService) { this.colheitaService = colheitaService; }

    @PostMapping
    public ResponseEntity<Colheita> cadastrarColheita(@RequestBody Colheita colheita) {
        Colheita novaColheita = colheitaService.cadastrarColheita(colheita);
        return ResponseEntity.ok(novaColheita);
    }

}
