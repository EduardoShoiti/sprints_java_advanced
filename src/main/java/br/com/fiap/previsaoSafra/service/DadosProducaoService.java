package br.com.fiap.previsaoSafra.service;

import br.com.fiap.previsaoSafra.controller.dto.DadosProducaoDTO;
import br.com.fiap.previsaoSafra.model.DadosProducao;
import br.com.fiap.previsaoSafra.repository.DadosProducaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DadosProducaoService {

    @Autowired
    private DadosProducaoRepository dadosProducaoRepository;

    public DadosProducao cadastrarDadosProducao(DadosProducaoDTO dadosProducaoDTO) {
        DadosProducao dadosProducao = new DadosProducao();
        dadosProducao.setDataColheita(dadosProducaoDTO.getDataColheita());
        dadosProducao.setQtdProduzida(dadosProducaoDTO.getQtdProduzida());
        return dadosProducaoRepository.save(dadosProducao); }

    public DadosProducao atualizarDadosProducao(Long id, DadosProducaoDTO novoDadosProducao){
        Optional<DadosProducao> dadosProducaoExiste= dadosProducaoRepository.findById(id);

        if (dadosProducaoExiste.isPresent()){
            DadosProducao dadosProducaoAtualizado=dadosProducaoExiste.get();

            dadosProducaoAtualizado.setColheita(novoDadosProducao.getColheita());
            dadosProducaoAtualizado.setDataColheita(novoDadosProducao.getDataColheita());
            dadosProducaoAtualizado.setQtdProduzida(novoDadosProducao.getQtdProduzida());
            dadosProducaoAtualizado.setListaFertilizantes(novoDadosProducao.getListaFertilizantes());
            return dadosProducaoRepository.save(dadosProducaoAtualizado);
        } else{
            throw new RuntimeException("Dados Produção não encontrada com o ID: "+id);
        }
    }

    public List<DadosProducao> listarDadosProducao() {return dadosProducaoRepository.findAll();}
    public void removerDadosProducao(Long id){
        if (dadosProducaoRepository.existsById(id)){
            dadosProducaoRepository.deleteById(id);
        }else{
            throw new RuntimeException("Dados Produção não encontrados com o ID: "+id);
        }
    }
}
