package br.com.fiap.previsaoSafra.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class DadosClimaticos {
    @Id
    @GeneratedValue
    private Long id;
    private LocalDate dataLocal;
    private Double temperaturaGraus;
    private Integer umidade;
    private Double precipitacao;

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
}
