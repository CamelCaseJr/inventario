package br.com.inventario.domain.model.departamento;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.xa.XAException;
import java.util.List;

@Service
public class DepartamentoService {

    private final DepartamentoRepository departamentoRepository;

    private final ModelMapper mapper;
    public DepartamentoService(DepartamentoRepository departamentoRepository, ModelMapper mapper) {
        this.departamentoRepository = departamentoRepository;
        this.mapper = mapper;
    }


    public List<DepartamentoDto> getDepartamentos (){

        var departamentos = departamentoRepository.findAll()
                .stream()
                .map(departamento -> mapper.map(departamento, DepartamentoDto.class) )
                .toList();
        return departamentos;
    }


    public DepartamentoDto save(DepartamentoDto departamentoDto){
        Departamento departamentoMap = mapper.map(departamentoDto, Departamento.class);
        return departamentoRepository.save(departamentoMap);

    }




}
