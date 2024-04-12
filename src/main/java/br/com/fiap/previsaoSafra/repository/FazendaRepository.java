package br.com.fiap.previsaoSafra.repository;

import br.com.fiap.previsaoSafra.model.Fazenda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FazendaRepository extends JpaRepository<Fazenda,Long> {

    List<Fazenda> findByDono(String dono);

}
