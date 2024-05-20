package br.com.fiap.previsaoSafra.controller;

import br.com.fiap.previsaoSafra.controller.dto.ColheitaDTO;
import br.com.fiap.previsaoSafra.controller.dto.FazendaDTO;
import br.com.fiap.previsaoSafra.model.Colheita;
import br.com.fiap.previsaoSafra.model.Fazenda;
import br.com.fiap.previsaoSafra.repository.ColheitaRepository;
import br.com.fiap.previsaoSafra.service.ColheitaService;
import br.com.fiap.previsaoSafra.service.FazendaService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/colheita")
public class ColheitaController {
    private final ColheitaService colheitaService;

    @Autowired
    public ColheitaController(ColheitaService colheitaService) { this.colheitaService = colheitaService; }

    @PostMapping
    public ResponseEntity<Colheita> cadastrarColheita(@Valid @RequestBody ColheitaDTO colheita) {
        Colheita novaColheita = colheitaService.cadastrarColheita(colheita);
        return ResponseEntity.ok(novaColheita);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Colheita> atualizarColheita(@PathVariable Long id, @RequestBody ColheitaDTO novaColheita) {
        Colheita colheitaAtualizada = colheitaService.atualizarColheita(id, novaColheita);
        return ResponseEntity.ok(colheitaAtualizada);
    }

    @GetMapping
    public ResponseEntity<List<Colheita>> listarColheita() {
        List<Colheita> colheitas = colheitaService.listarColheitas();
        return ResponseEntity.ok(colheitas);
    }

    @GetMapping("/buscar")
    public List<Colheita> buscarColheitas(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) String tipo,
            @RequestParam(required = false) String estacaoDoAno) {
        return colheitaService.listarColheitaPorAtributo(nome, tipo, estacaoDoAno);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerColheita(@PathVariable Long id) {
        colheitaService.removerColheita(id);
        return ResponseEntity.ok().build();
    }

}
