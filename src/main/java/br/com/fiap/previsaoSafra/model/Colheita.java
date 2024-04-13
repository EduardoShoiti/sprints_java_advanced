package br.com.fiap.previsaoSafra.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Colheita {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String tipo;
    private String estacaoDoAno;
    @OneToMany(mappedBy = "colheita", cascade = CascadeType.ALL)
    private List<DadosProducao> dadosProducao;
    @ManyToOne(cascade = CascadeType.ALL)
    private Fazenda fazenda;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstacaoDoAno() {
        return estacaoDoAno;
    }

    public void setEstacaoDoAno(String estacaoDoAno) {
        this.estacaoDoAno = estacaoDoAno;
    }

    public List<DadosProducao> getDadosProducao() {
        return dadosProducao;
    }

    public void setDadosProducao(List<DadosProducao> dadosProducao) {
        this.dadosProducao = dadosProducao;
    }

    public Fazenda getFazenda() {
        return fazenda;
    }

    public void setFazenda(Fazenda fazenda) {
        this.fazenda = fazenda;
    }
}
