package br.com.fiap.previsaoSafra.controller.dto;

import br.com.fiap.previsaoSafra.model.Colheita;
import br.com.fiap.previsaoSafra.model.DadosClimaticos;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class FazendaDTO {
    private Long id;

    @NotBlank
    private String dono;

    @NotBlank
    private String latitude;

    @NotBlank
    private String longitude;

    @NotNull
    private Integer tamanho;

    private List<Colheita> listaColheita;

    private List<DadosClimaticos> dadosClimaticos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDono() {
        return dono;
    }

    public void setDono(String dono) {
        this.dono = dono;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public Integer getTamanho() {
        return tamanho;
    }

    public void setTamanho(Integer tamanho) {
        this.tamanho = tamanho;
    }

    public List<Colheita> getListaColheita() {
        return listaColheita;
    }

    public void setListaColheita(List<Colheita> listaColheita) {
        this.listaColheita = listaColheita;
    }

    public List<DadosClimaticos> getDadosClimaticos() {
        return dadosClimaticos;
    }

    public void setDadosClimaticos(List<DadosClimaticos> dadosClimaticos) {
        this.dadosClimaticos = dadosClimaticos;
    }
}
