package br.com.fiap.previsaoSafra.controller.dto;


import br.com.fiap.previsaoSafra.model.DadosProducao;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
public class ColheitaDTO {

    private Long id;
    private String nome;
    private String tipo;
    private String estacaoDoAno;
    private List<DadosProducao> dadosProducao;

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getNome() {return nome;}

    public void setNome(String nome) {this.nome = nome;}
    public String getTipo() {return tipo;}

    public void setTipo(String tipo) {this.tipo = tipo;}

    public String getEstacaoDoAno() {return estacaoDoAno;}

    public void setEstacaoDoAno(String estacaoDoAno) {this.estacaoDoAno = estacaoDoAno;    }

    public List<DadosProducao> getDadosProducao() {return dadosProducao;}

    public void setDadosProducao(List<DadosProducao> dadosProducao) {this.dadosProducao = dadosProducao;}
}

