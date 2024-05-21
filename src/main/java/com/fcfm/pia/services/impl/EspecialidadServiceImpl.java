package com.fcfm.pia.services.impl;

import com.fcfm.pia.models.Especialidad;
import com.fcfm.pia.repository.interfaces.EspecialidadRepository;
import com.fcfm.pia.services.interfaces.EspecialidadService;
import com.fcfm.pia.utils.mappers.EspecialidadMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EspecialidadServiceImpl implements EspecialidadService {

    private EspecialidadRepository especialidadRepository;

    @Autowired
    EspecialidadServiceImpl(EspecialidadRepository especialidadRepository){
        this.especialidadRepository = especialidadRepository;
    }
    @Override
    public List<Especialidad> getEspecialidadList() {
        var especialidadesEntity = especialidadRepository.getEspecialidadList();

        return especialidadesEntity.stream()
                .map(EspecialidadMapper::EspecilidadEntityToEspecilidadModel)
                .collect(Collectors.toList());
    }
}
