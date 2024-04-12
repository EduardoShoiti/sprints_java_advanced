package br.com.fiap.previsaoSafra.repository;

import br.com.fiap.previsaoSafra.model.Colheita;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ColheitaRepository extends JpaRepository<Colheita,Long> {

    List<Colheita> findByNomeContainingOrTipoContainingOrEstacaoDoAnoContaining(String nome, String tipo, String estacaoDoAno);

}
