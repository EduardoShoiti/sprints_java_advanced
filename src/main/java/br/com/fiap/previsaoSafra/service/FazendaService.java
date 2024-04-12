package br.com.fiap.previsaoSafra.service;

import br.com.fiap.previsaoSafra.controller.dto.FazendaDTO;
import br.com.fiap.previsaoSafra.model.Fazenda;
import br.com.fiap.previsaoSafra.repository.FazendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FazendaService {

    @Autowired
    private FazendaRepository fazendaRepository;

//    Cadastrar fazenda
    public Fazenda cadastrarFazenda(Fazenda fazenda) { return fazendaRepository.save(fazenda); }

//    Atualizar fazenda
    public Fazenda atualizarFazenda(Long id, FazendaDTO novaFazenda) {
        Optional<Fazenda> fazendaExistente = fazendaRepository.findById(id);

        if (fazendaExistente.isPresent()) {
            Fazenda fazendaAtualizada = fazendaExistente.get();

            fazendaAtualizada.setDono(novaFazenda.getDono());
            fazendaAtualizada.setLatitude(novaFazenda.getLatitude());
            fazendaAtualizada.setLongitude(novaFazenda.getLongitude());
            fazendaAtualizada.setTamanho(novaFazenda.getTamanho());
            fazendaAtualizada.setListaColheita(novaFazenda.getListaColheita());
            fazendaAtualizada.setDadosClimaticos(novaFazenda.getDadosClimaticos());
            return fazendaRepository.save(fazendaAtualizada);
        } else {
            throw new RuntimeException("Fazenda não encontrada com o ID: " + id);
        }
    }

//    Listar as Fazendas
    public List<Fazenda> listarFazendas() { return fazendaRepository.findAll(); }

    public List<Fazenda> listarFazendaPeloDono(String dono) { return fazendaRepository.findByDono(dono); }

//    Deletar Fazenda

    public void removerFazenda(Long id) {
        if (fazendaRepository.existsById(id)) {
            fazendaRepository.deleteById(id);
        } else {
            throw new RuntimeException("Fazenda não encontrado com o ID: " + id);
        }
    }

}
