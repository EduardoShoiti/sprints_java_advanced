package br.com.fiap.previsaoSafra.controller;

import br.com.fiap.previsaoSafra.controller.dto.DadosClimaticosDTO;
import br.com.fiap.previsaoSafra.controller.dto.DadosProducaoDTO;
import br.com.fiap.previsaoSafra.model.DadosClimaticos;
import br.com.fiap.previsaoSafra.model.DadosProducao;
import br.com.fiap.previsaoSafra.service.DadosClimaticosService;
import br.com.fiap.previsaoSafra.service.DadosProducaoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dadosclimaticos")
public class DadosClimaticosController {
    private final DadosClimaticosService dadosClimaticosService;
    @Autowired
    public DadosClimaticosController(DadosClimaticosService dadosClimaticosService) {this.dadosClimaticosService = dadosClimaticosService; }
    @PostMapping
    public ResponseEntity<DadosClimaticos> cadastrarDadosClimaticos(@Valid @RequestBody DadosClimaticosDTO dadosClimaticos){
        DadosClimaticos novoDadosClimaticos = dadosClimaticosService.cadastrarDadosClimaticos(dadosClimaticos);
        return ResponseEntity.ok(novoDadosClimaticos);

    }
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DadosClimaticos>atualizarDadosClimaticos(@PathVariable Long id, @RequestBody DadosClimaticosDTO novoDadosClimaticos){
        DadosClimaticos dadosClimaticosAtualizado = dadosClimaticosService.atualizarDadosClimaticos(id, novoDadosClimaticos);
        return ResponseEntity.ok(dadosClimaticosAtualizado);
    }
    @GetMapping
    public ResponseEntity<List<DadosClimaticos>>listarDadosClimaticos(){
        List<DadosClimaticos>DadosClimaticos=dadosClimaticosService.listarDadosClimaticos();
        return ResponseEntity.ok(DadosClimaticos);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerDadosClimaticos(@PathVariable Long id){
        dadosClimaticosService.removerDadosClimaticos(id);
        return ResponseEntity.ok().build();
    }


}
