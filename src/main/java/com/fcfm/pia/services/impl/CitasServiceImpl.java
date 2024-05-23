package com.fcfm.pia.services.impl;

import com.fcfm.pia.models.Cita;
import com.fcfm.pia.repository.entities.CitaEntity;
import com.fcfm.pia.repository.interfaces.CitasRepository;
import com.fcfm.pia.repository.interfaces.EspecialidadRepository;
import com.fcfm.pia.services.interfaces.CitasService;
import com.fcfm.pia.utils.mappers.CitaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CitasServiceImpl implements CitasService {

    private CitasRepository citasRepository;

    @Autowired
    CitasServiceImpl(CitasRepository citasRepository){
        this.citasRepository = citasRepository;
    }

    //model to entity
    @Override
    public void setCita(Cita cita) {
        citasRepository.setCita(CitaMapper.CitaModeltoCitaEntity(cita));
    }

    //entity to model
    @Override
    public List<Cita> getCitas(String inicio, String fin) {
        var citasEntity = this.citasRepository.getCitas(inicio,fin);

        return citasEntity.stream().map(CitaMapper::CitaEntityToCitaModel).collect(Collectors.toList());
    }

    //entity to model
    @Override
    public Optional<Cita> getCita(long idCita) {
        Optional<CitaEntity> citaEntity = citasRepository.getCita(idCita);

        // Si citaEntity está presente, mapear a Cita, de lo contrario retornar un Optional vacío
        if (citaEntity.isPresent()) {
            Cita cita = CitaMapper.CitaEntityToCitaModel(citaEntity.get());
            return Optional.ofNullable(cita);
        } else {
            return Optional.empty();
        }
    }

    //model to entity...y de nuevo a model?
    @Override
    public Cita updateCita(long idCita, Cita cita) {
        CitaEntity citaActualizada =  citasRepository.updateCita(idCita, CitaMapper.CitaModeltoCitaEntity(cita));
        return CitaMapper.CitaEntityToCitaModel(citaActualizada);
    }

    //model to entity
    @Override
    public void deleteCita(long idCita) {
        citasRepository.deleteCita(idCita);
    }
}
