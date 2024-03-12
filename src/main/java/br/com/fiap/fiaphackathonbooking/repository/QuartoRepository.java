package br.com.fiap.fiaphackathonbooking.repository;

import br.com.fiap.fiaphackathonbooking.model.Quarto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface QuartoRepository extends JpaRepository<Quarto, Long> {
    @Query("SELECT CASE WHEN COUNT(r) = 0 THEN true ELSE false END FROM Reserva r JOIN r.quartos q WHERE q.id = :quartoId AND r.dataSaida > :dataInicio AND r.dataEntrada < :dataFim")
    boolean isQuartoDisponivel(@Param("quartoId") Long quartoId, @Param("dataInicio") LocalDate dataInicio, @Param("dataFim") LocalDate dataFim);

}
