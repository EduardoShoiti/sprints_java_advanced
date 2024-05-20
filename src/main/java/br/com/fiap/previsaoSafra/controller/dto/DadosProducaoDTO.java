package br.com.fiap.previsaoSafra.controller.dto;

import br.com.fiap.previsaoSafra.model.Colheita;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class DadosProducaoDTO {
    private Long id;
    private Colheita colheita;

    @NotBlank
    private LocalDate dataColheita;

    @NotNull
    private Integer qtdProduzida;

    private List<String> listaFertilizantes;

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

    public LocalDate getDataColheita() {
        return dataColheita;
    }

    public void setDataColheita(LocalDate dataColheita) {
        this.dataColheita = dataColheita;
    }

    public Integer getQtdProduzida() {
        return qtdProduzida;
    }

    public void setQtdProduzida(Integer qtdProduzida) {
        this.qtdProduzida = qtdProduzida;
    }

    public List<String> getListaFertilizantes() {
        return listaFertilizantes;
    }

    public void setListaFertilizantes(List<String> listaFertilizantes) {
        this.listaFertilizantes = listaFertilizantes;
    }
}
