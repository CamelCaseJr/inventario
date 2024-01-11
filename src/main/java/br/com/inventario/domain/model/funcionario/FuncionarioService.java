package br.com.inventario.domain.model.funcionario;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;
    private final ModelMapper mapper;

    public FuncionarioService(FuncionarioRepository funcionarioRepository, ModelMapper mapper) {
        this.funcionarioRepository = funcionarioRepository;
        this.mapper = mapper;
    }


    public Page<FuncionarioDto> findAll(Pageable paginacao) {
        return funcionarioRepository.findAll(paginacao)
                .map(element -> mapper.map(element, FuncionarioDto.class));
    }

    public FuncionarioDto findById(UUID id) {
        var funcionario = getFuncionarioPorId(id);
        return mapper.map(funcionario, FuncionarioDto.class);
    }

    public FuncionarioDto save(FuncionarioDto dados) {
        var funcionario = mapper.map(dados, Funcionario.class);
        var funcionarioSalvo = funcionarioRepository.save(funcionario);
        return mapper.map(funcionarioSalvo, FuncionarioDto.class);
    }

    public FuncionarioDto update(UUID id, @Valid FuncionarioDto dados) {
        Funcionario funcionario = mapper.map(dados, Funcionario.class);
        funcionario.setId(id);
        var funcionarioSalvo = funcionarioRepository.save(funcionario);
        return mapper.map(funcionarioSalvo, FuncionarioDto.class);
    }

    public void delete(UUID id) {
        funcionarioRepository.deleteById(id);
    }

    private Funcionario getFuncionarioPorId(UUID id) {
        return funcionarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Funcionário não encontrado"));
    }
}

