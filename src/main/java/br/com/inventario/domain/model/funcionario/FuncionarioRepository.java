package br.com.inventario.domain.model.funcionario;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, UUID> {

    Optional<FuncionarioDto> findByName(String nome);
}
