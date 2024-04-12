package br.com.fiap.previsaoSafra.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Predicao {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    @JoinColumn(name = "colheita_id")
    private Colheita colheita;
    @ManyToOne
    @JoinColumn(name = "fazenda_id")
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
