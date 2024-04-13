package br.com.fiap.previsaoSafra.controller.dto;

import br.com.fiap.previsaoSafra.model.Fazenda;
import lombok.Data;

import java.time.LocalDate;

@Data
public class DadosClimaticosDTO {

    private Long id;
    private LocalDate dataLocal;
    private Double temperaturaGraus;
    private Integer umidade;
    private Double precipitacao;
    private Fazenda fazenda;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataLocal() {
        return dataLocal;
    }

    public void setDataLocal(LocalDate dataLocal) {
        this.dataLocal = dataLocal;
    }

    public Double getTemperaturaGraus() {
        return temperaturaGraus;
    }

    public void setTemperaturaGraus(Double temperaturaGraus) {
        this.temperaturaGraus = temperaturaGraus;
    }

    public Integer getUmidade() {
        return umidade;
    }

    public void setUmidade(Integer umidade) {
        this.umidade = umidade;
    }

    public Double getPrecipitacao() {
        return precipitacao;
    }

    public void setPrecipitacao(Double precipitacao) {
        this.precipitacao = precipitacao;
    }

    public Fazenda getFazenda() {
        return fazenda;
    }

    public void setFazenda(Fazenda fazenda) {
        this.fazenda = fazenda;
    }
}

