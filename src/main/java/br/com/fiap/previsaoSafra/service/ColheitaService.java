package br.com.fiap.previsaoSafra.service;

import br.com.fiap.previsaoSafra.controller.dto.ColheitaDTO;
import br.com.fiap.previsaoSafra.controller.dto.FazendaDTO;
import br.com.fiap.previsaoSafra.model.Colheita;
import br.com.fiap.previsaoSafra.model.Fazenda;
import br.com.fiap.previsaoSafra.repository.ColheitaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ColheitaService {
    @Autowired
    private ColheitaRepository colheitaRepository;

    //    Cadastrar Colheita
    public Colheita cadastrarColheita(Colheita colheita) { return colheitaRepository.save(colheita); }

    //    Atualizar Colheita
    public Colheita atualizarColheita(Long id, ColheitaDTO novaColheita) {
        Optional<Colheita> colheitaExistente = colheitaRepository.findById(id);

        if (colheitaExistente.isPresent()) {
            Colheita colheitaAtualizada = colheitaExistente.get();

            colheitaAtualizada.setNome(novaColheita.getNome());
            colheitaAtualizada.setTipo(novaColheita.getTipo());
            colheitaAtualizada.setEstacaoDoAno(novaColheita.getEstacaoDoAno());
            colheitaAtualizada.setDadosProducao(novaColheita.getDadosProducao());
            return colheitaRepository.save(colheitaAtualizada);
        } else {
            throw new RuntimeException("Colheita não encontrada com o ID: " + id);
        }
    }

//    Listar as Colheitas

    public List<Colheita> listarColheitas() { return colheitaRepository.findAll(); }

    public List<Colheita> listarFazendaPorAtributo(String nome, String tipo, String estacaoDoAno) {
        return colheitaRepository.findByNomeContainingOrTipoContainingOrEstacaoDoAnoContaining(nome, tipo, estacaoDoAno);
    }

}
