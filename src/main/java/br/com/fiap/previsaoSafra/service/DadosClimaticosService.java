package br.com.fiap.previsaoSafra.service;

import br.com.fiap.previsaoSafra.controller.dto.DadosClimaticosDTO;
import br.com.fiap.previsaoSafra.controller.dto.DadosProducaoDTO;
import br.com.fiap.previsaoSafra.model.DadosClimaticos;
import br.com.fiap.previsaoSafra.model.DadosProducao;
import br.com.fiap.previsaoSafra.repository.DadosClimaticosRepository;
import br.com.fiap.previsaoSafra.repository.DadosProducaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DadosClimaticosService {

    @Autowired
    private DadosClimaticosRepository dadosClimaticosRepository;

    public DadosClimaticos cadastrarDadosClimaticos(DadosClimaticosDTO dadosClimaticosDTO) {
        DadosClimaticos dadosClimaticos = new DadosClimaticos();
        dadosClimaticos.setDataLocal(dadosClimaticosDTO.getDataLocal());
        dadosClimaticos.setTemperaturaGraus(dadosClimaticosDTO.getTemperaturaGraus());
        dadosClimaticos.setUmidade(dadosClimaticosDTO.getUmidade());
        dadosClimaticos.setPrecipitacao(dadosClimaticosDTO.getPrecipitacao());
        return dadosClimaticosRepository.save(dadosClimaticos); }

    public DadosClimaticos atualizarDadosClimaticos(Long id, DadosClimaticosDTO novoDadosClimaticos){
        Optional<DadosClimaticos> dadosClimaticosExiste= dadosClimaticosRepository.findById(id);

        if (dadosClimaticosExiste.isPresent()){
            DadosClimaticos dadosClimaticosAtualizado = dadosClimaticosExiste.get();

            dadosClimaticosAtualizado.setDataLocal(novoDadosClimaticos.getDataLocal());
            dadosClimaticosAtualizado.setTemperaturaGraus(novoDadosClimaticos.getTemperaturaGraus());
            dadosClimaticosAtualizado.setUmidade(novoDadosClimaticos.getUmidade());
            dadosClimaticosAtualizado.setPrecipitacao(novoDadosClimaticos.getPrecipitacao());
            dadosClimaticosAtualizado.setFazenda(novoDadosClimaticos.getFazenda());
            return dadosClimaticosRepository.save(dadosClimaticosAtualizado);
        } else{
            throw new RuntimeException("Dados Climáticos não encontrada com o ID: "+id);
        }
    }

    public List<DadosClimaticos> listarDadosClimaticos() {return dadosClimaticosRepository.findAll();}
    public void removerDadosClimaticos(Long id){
        if (dadosClimaticosRepository.existsById(id)){
            dadosClimaticosRepository.deleteById(id);
        }else{
            throw new RuntimeException("Dados Climáticos não encontrados com o ID: "+id);
        }
    }
}

