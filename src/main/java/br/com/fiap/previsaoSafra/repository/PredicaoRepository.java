package br.com.fiap.previsaoSafra.repository;

import br.com.fiap.previsaoSafra.model.Predicao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PredicaoRepository extends JpaRepository<Predicao,Long> {
}
