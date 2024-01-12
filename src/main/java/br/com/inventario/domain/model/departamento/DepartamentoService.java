package br.com.inventario.domain.model.departamento;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.xa.XAException;
import java.util.List;
import java.util.UUID;

@Service
public class DepartamentoService {

    private final DepartamentoRepository departamentoRepository;

    private final ModelMapper mapper;
    public DepartamentoService(DepartamentoRepository departamentoRepository, ModelMapper mapper) {
        this.departamentoRepository = departamentoRepository;
        this.mapper = mapper;
    }


    public Page<DepartamentoDto> findAll (Pageable pageable){

        return departamentoRepository.findAll(pageable)
                .map(departamento -> mapper.map(departamento, DepartamentoDto.class) );

    }


    public DepartamentoDto save(DepartamentoDto departamentoDto){
        Departamento departamentoMap = mapper.map(departamentoDto, Departamento.class);
        var departamentoSalvo =  departamentoRepository.save(departamentoMap);
        return mapper.map(departamentoSalvo, DepartamentoDto.class);
    }

    public DepartamentoDto update (UUID id , DepartamentoDto departamentoDto){
        Departamento departamento = mapper.map(departamentoDto, Departamento.class);
        departamento.setId(id);
        Departamento save = departamentoRepository.save(departamento);
        return mapper.map(save, DepartamentoDto.class);
    }

    public void delete (UUID id ){
        departamentoRepository.deleteById(id);
    }








}
