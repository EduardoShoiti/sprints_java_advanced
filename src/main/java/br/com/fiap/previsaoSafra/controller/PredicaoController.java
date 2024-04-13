package br.com.fiap.previsaoSafra.controller;

import br.com.fiap.previsaoSafra.controller.dto.FazendaDTO;
import br.com.fiap.previsaoSafra.controller.dto.PredicaoDTO;
import br.com.fiap.previsaoSafra.model.Fazenda;
import br.com.fiap.previsaoSafra.model.Predicao;
import br.com.fiap.previsaoSafra.service.FazendaService;
import br.com.fiap.previsaoSafra.service.PredicaoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/predicao")
public class PredicaoController {
    private final PredicaoService predicaoService;

    @Autowired
    public PredicaoController(PredicaoService predicaoService) { this.predicaoService = predicaoService; }

    @PostMapping
    public ResponseEntity<Predicao> cadastrarPredicao(@RequestBody Predicao predicao) {
        Predicao novaPredicao = predicaoService.cadastrarPredicao(predicao);
        return ResponseEntity.ok(novaPredicao);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Predicao> atualizarPredicao(@PathVariable Long id, @RequestBody PredicaoDTO novaPredicao) {
        Predicao predicaoAtualizada = predicaoService.atualizarPredicao(id, novaPredicao);
        return ResponseEntity.ok(predicaoAtualizada);
    }

    @GetMapping
    public ResponseEntity<List<Predicao>> listarPredicao() {
        List<Predicao> predicao = predicaoService.listarPredicao();
        return ResponseEntity.ok(predicao);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerPredicao(@PathVariable Long id) {
        predicaoService.removerPredicao(id);
        return ResponseEntity.ok().build();
    }

}
