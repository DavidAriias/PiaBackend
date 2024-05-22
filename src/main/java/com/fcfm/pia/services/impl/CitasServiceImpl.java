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
        return;
    }

    //entity to model
    @Override
    public List<Cita> getCitas(String inicio, String fin) {
        return null;
    }

    //entity to model
    @Override
    public Cita getCita(long idCita) {
        CitaEntity citaEntity = citasRepository.getCita(idCita);
        return CitaMapper.CitaEntitytoCitaModel(citaEntity);
    }

    //model to entity...y de nuevo a model?
    @Override
    public Cita updateCita(int idCita) {
        return null;
    }

    //model to entity
    @Override
    public void deleteCita(int idCita) {
        return;
    }
}
