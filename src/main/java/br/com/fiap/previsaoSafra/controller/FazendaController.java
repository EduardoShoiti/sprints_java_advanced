package br.com.fiap.previsaoSafra.controller;

import br.com.fiap.previsaoSafra.controller.dto.FazendaDTO;
import br.com.fiap.previsaoSafra.model.Fazenda;
import br.com.fiap.previsaoSafra.service.FazendaService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fazenda")
public class FazendaController {

    private final FazendaService fazendaService;

    @Autowired
    public FazendaController(FazendaService fazendaService) { this.fazendaService = fazendaService; }

    @PostMapping
    public ResponseEntity<Fazenda> cadastrarFazenda(@Valid @RequestBody FazendaDTO fazenda) {
        Fazenda novaFazenda = fazendaService.cadastrarFazenda(fazenda);
        return ResponseEntity.ok(novaFazenda);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Fazenda> atualizarFazenda(@PathVariable Long id, @RequestBody FazendaDTO novaFazenda) {
        Fazenda fazendaAtualizada = fazendaService.atualizarFazenda(id, novaFazenda);
        return ResponseEntity.ok(fazendaAtualizada);
    }

    @GetMapping
    public ResponseEntity<List<Fazenda>> listarFazenda() {
        List<Fazenda> fazendas = fazendaService.listarFazendas();
        return ResponseEntity.ok(fazendas);
    }

    @GetMapping("/{dono}")
    public ResponseEntity<List<Fazenda>> listarFazendaPeloDono(@RequestParam(required = false) String dono) {
        List<Fazenda> fazendasPeloDono = fazendaService.listarFazendaPeloDono(dono);
        return ResponseEntity.ok(fazendasPeloDono);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerFazenda(@PathVariable Long id) {
        fazendaService.removerFazenda(id);
        return ResponseEntity.ok().build();
    }

}
