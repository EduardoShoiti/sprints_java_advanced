package br.com.fiap.previsaoSafra.repository;

import br.com.fiap.previsaoSafra.model.DadosClimaticos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DadosClimaticosRepository extends JpaRepository<DadosClimaticos,Long> {
}
