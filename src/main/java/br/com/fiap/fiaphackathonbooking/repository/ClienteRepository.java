package br.com.fiap.fiaphackathonbooking.repository;

import br.com.fiap.fiaphackathonbooking.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository  extends JpaRepository<Cliente, Long> {
}
