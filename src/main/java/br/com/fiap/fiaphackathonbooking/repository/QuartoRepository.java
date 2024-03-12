package br.com.fiap.fiaphackathonbooking.repository;

import br.com.fiap.fiaphackathonbooking.model.Quarto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuartoRepository extends JpaRepository<Quarto, Long> {
}
