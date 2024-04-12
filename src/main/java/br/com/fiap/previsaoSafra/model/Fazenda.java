package br.com.fiap.previsaoSafra.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Fazenda {
    @Id
    @GeneratedValue
    private Long id;
    private String dono;
    private Double latitude;
    private Double longitude;
    private Integer tamanho;

    @OneToMany(mappedBy = "fazenda")
    //1 fazenda pode ter varias culturas
    private List<Colheita> listaColheita;
    @OneToMany(mappedBy = "fazenda")
    //1 fazenda pode ter varios historicos de dados climaticos
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

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
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
