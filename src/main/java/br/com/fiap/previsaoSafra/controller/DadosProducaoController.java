package br.com.fiap.previsaoSafra.controller;

import br.com.fiap.previsaoSafra.controller.dto.DadosProducaoDTO;
import br.com.fiap.previsaoSafra.model.DadosProducao;
import br.com.fiap.previsaoSafra.service.DadosProducaoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
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
    @PostMapping
    public ResponseEntity<DadosProducao>cadastrarDadosProducao(@Valid @RequestBody DadosProducaoDTO dadosProducao){
        DadosProducao novoDadosProducao = dadosProducaoService.cadastrarDadosProducao(dadosProducao);
        return ResponseEntity.ok(novoDadosProducao);

    }
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DadosProducao>atualizarDadosProducao(@PathVariable Long id, @RequestBody DadosProducaoDTO novoDadosProducao){
        DadosProducao dadosProducaoAtualizado = dadosProducaoService.atualizarDadosProducao(id, novoDadosProducao);
        return ResponseEntity.ok(dadosProducaoAtualizado);
    }
    @GetMapping
    public ResponseEntity<List<DadosProducao>>listarDadosProducao(){
        List<DadosProducao>DadosProducao=dadosProducaoService.listarDadosProducao();
        return ResponseEntity.ok(DadosProducao);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerDadosProducao(@PathVariable Long id){
        dadosProducaoService.removerDadosProducao(id);
        return ResponseEntity.ok().build();
    }


}
