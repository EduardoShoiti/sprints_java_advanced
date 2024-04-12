package br.com.fiap.previsaoSafra.controller.dto;

import br.com.fiap.previsaoSafra.model.Colheita;
import br.com.fiap.previsaoSafra.model.Fazenda;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PredicaoDTO {
    private Long id;
    private Colheita colheita;
    private Fazenda fazenda;
    private LocalDate dataPredicao;
    private Integer qtdPrevista;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Colheita getColheita() {
        return colheita;
    }

    public void setColheita(Colheita colheita) {
        this.colheita = colheita;
    }

    public Fazenda getFazenda() {
        return fazenda;
    }

    public void setFazenda(Fazenda fazenda) {
        this.fazenda = fazenda;
    }

    public LocalDate getDataPredicao() {
        return dataPredicao;
    }

    public void setDataPredicao(LocalDate dataPredicao) {
        this.dataPredicao = dataPredicao;
    }

    public Integer getQtdPrevista() {
        return qtdPrevista;
    }

    public void setQtdPrevista(Integer qtdPrevista) {
        this.qtdPrevista = qtdPrevista;
    }
}

