package br.com.fiap.fiaphackathonbooking.repository;

import br.com.fiap.fiaphackathonbooking.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository  extends JpaRepository<Cliente, Long> {

    Optional<Cliente> findByCpf(String cpf);
}
