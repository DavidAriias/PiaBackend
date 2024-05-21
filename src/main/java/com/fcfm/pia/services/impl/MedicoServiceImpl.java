package com.fcfm.pia.services.impl;

import com.fcfm.pia.models.Medico;
import com.fcfm.pia.repository.interfaces.MedicoRepository;
import com.fcfm.pia.services.interfaces.MedicoService;
import com.fcfm.pia.utils.mappers.MedicoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedicoServiceImpl implements MedicoService {

    private MedicoRepository medicoRepository;

    @Autowired
    public MedicoServiceImpl(MedicoRepository medicoRepository){
        this.medicoRepository = medicoRepository;
    }

    @Override
    public List<Medico> getMedicosByEspecialidad(Long idEspecialidad) {
      var medicosEntity = this.medicoRepository.getMedicosByEspecialidad(idEspecialidad);

        return medicosEntity.stream()
                .map(MedicoMapper::MedicoEntityToMedicoModel)
                .collect(Collectors.toList());
    }
}