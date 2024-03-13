package br.com.fiap.fiaphackathonbooking.repository;

import br.com.fiap.fiaphackathonbooking.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    @Query("SELECT CASE WHEN COUNT(r) > 0 THEN true ELSE false END " +
            "FROM Reserva r " +
            "JOIN r.quartos q " +
            "WHERE r.id <> :reservaId " +
            "AND q.id = :quartoId " +
            "AND (:dataSaida BETWEEN r.dataEntrada AND r.dataSaida " +
            "OR :dataEntrada BETWEEN r.dataEntrada AND r.dataSaida)")
    boolean existsReservaConflitoOutrasReservas(@Param("reservaId") Long reservaId,
                                                @Param("quartoId") Long quartoId,
                                                @Param("dataEntrada") LocalDate dataEntrada,
                                                @Param("dataSaida") LocalDate dataSaida);

}
