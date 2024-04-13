package br.com.fiap.previsaoSafra.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Fazenda {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String dono;
    private String latitude;
    private String longitude;
    private Integer tamanho;

    //1 fazenda pode ter varias culturas
    @OneToMany(mappedBy = "fazenda", cascade = CascadeType.ALL)
    private List<Colheita> listaColheita;

    //1 fazenda pode ter varios historicos de dados climaticos
    @OneToMany(mappedBy = "fazenda", cascade = CascadeType.ALL)
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
