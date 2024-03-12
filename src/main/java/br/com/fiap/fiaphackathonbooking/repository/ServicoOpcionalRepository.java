package br.com.fiap.fiaphackathonbooking.repository;

import br.com.fiap.fiaphackathonbooking.model.ServicoOpcional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServicoOpcionalRepository extends JpaRepository<ServicoOpcional, Long> {
    List<ServicoOpcional> findByNomeLikeIgnoreCase(@Param("nome") String nome);
}
