package br.com.fiap.previsaoSafra.service;

import br.com.fiap.previsaoSafra.controller.dto.FazendaDTO;
import br.com.fiap.previsaoSafra.controller.dto.PredicaoDTO;
import br.com.fiap.previsaoSafra.model.Fazenda;
import br.com.fiap.previsaoSafra.model.Predicao;
import br.com.fiap.previsaoSafra.repository.FazendaRepository;
import br.com.fiap.previsaoSafra.repository.PredicaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PredicaoService {
    @Autowired
    private PredicaoRepository predicaoRepository;

    //    Cadastrar predicao
    public Predicao cadastrarPredicao(PredicaoDTO predicaoDTO) {
        Predicao predicao = new Predicao();
        predicao.setDataPredicao(predicaoDTO.getDataPredicao());
        predicao.setQtdPrevista(predicaoDTO.getQtdPrevista());
        return predicaoRepository.save(predicao); }

    //    Atualizar predicao
    public Predicao atualizarPredicao(Long id, PredicaoDTO novaPredicao) {
        Optional<Predicao> predicaoExistente = predicaoRepository.findById(id);

        if (predicaoExistente.isPresent()) {
            Predicao predicaoAtualizada = predicaoExistente.get();
            predicaoAtualizada.setColheita(novaPredicao.getColheita());
            predicaoAtualizada.setFazenda(novaPredicao.getFazenda());
            predicaoAtualizada.setDataPredicao(novaPredicao.getDataPredicao());
            predicaoAtualizada.setQtdPrevista(novaPredicao.getQtdPrevista());
            return predicaoRepository.save(predicaoAtualizada);
        } else {
            throw new RuntimeException("Predição não encontrada com o ID: " + id);
        }
    }

    //    Listar as Predições
    public List<Predicao> listarPredicao() { return predicaoRepository.findAll(); }


//    Deletar Predicao

    public void removerPredicao(Long id) {
        if (predicaoRepository.existsById(id)) {
            predicaoRepository.deleteById(id);
        } else {
            throw new RuntimeException("Predição não encontrado com o ID: " + id);
        }
    }

}
