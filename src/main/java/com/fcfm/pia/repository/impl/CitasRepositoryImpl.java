package com.fcfm.pia.repository.impl;

import com.fcfm.pia.models.Cita;
import com.fcfm.pia.models.enums.CitaEstatusEnum;
import com.fcfm.pia.repository.entities.*;
import com.fcfm.pia.repository.interfaces.CitasRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.*;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CitasRepositoryImpl implements CitasRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public CitaEntity setCita(CitaEntity cita) {

        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();

        // Crear un CriteriaQuery para la consulta de CitaEntity
        CriteriaQuery<CitaEntity> criteriaQuery = criteriaBuilder.createQuery(CitaEntity.class);

        // Definir el root de la consulta (en este caso, la entidad CitaEntity)
        Root<CitaEntity> citaRoot = criteriaQuery.from(CitaEntity.class);

        // Crear los joins necesarios si quieres acceder a los atributos de las entidades relacionadas
        citaRoot.join("medico"); // Este join es necesario para acceder a los atributos de MedicoEntity

        // Crear las condiciones (predicados) que quieres aplicar
        Predicate idMedicoPredicate = criteriaBuilder.equal(citaRoot.get("medico").get("idMedico"), cita.getMedico().getIdMedico()); // Ajusta "id" según el atributo correcto en MedicoEntity
        Predicate fechaCitaPredicate = criteriaBuilder.equal(citaRoot.get("fechaCita"), cita.getFechaCita());
        Predicate estatusPrecidate = criteriaBuilder.notEqual(citaRoot.get("estatus").get("idCitaEstatus"), Long.parseLong(CitaEstatusEnum.CANCELADA.getValor()));

        // Combinar las condiciones utilizando and
        Predicate condiciones = criteriaBuilder.and(idMedicoPredicate, fechaCitaPredicate, estatusPrecidate);

        // Aplicar las condiciones al CriteriaQuery
        criteriaQuery.where(condiciones);

        // Crear y ejecutar la consulta TypedQuery
        TypedQuery<CitaEntity> typedQuery = em.createQuery(criteriaQuery);
        List<CitaEntity> citas = typedQuery.getResultList();

        if (!citas.isEmpty()) throw new RuntimeException("Error al agendar cita, ya existen cita o citas con medico y la horario solicitado");

       var paciente = em.find(PacienteEntity.class, cita.getPaciente().getIdPaciente());

       if (paciente == null) throw new RuntimeException("Error al obtener el paciente");

       cita.setPaciente(paciente);

        // Ahora persistimos la cita
        em.persist(cita);
        em.flush();  // Asegura que la entidad se persista inmediatamente
        em.refresh(cita);  // Asegura que la entidad tenga los datos más recientes de la base de datos

        return cita;
    }

    @Override
    public List<CitaEntity> getCitas(String horarioInicio, String horarioFin, Long idPaciente) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<CitaEntity> cq = cb.createQuery(CitaEntity.class);
        Root<CitaEntity> citaRoot = cq.from(CitaEntity.class);

        // Definir predicados para filtrar por fecha y paciente
        Predicate fechaPredicate = cb.between(citaRoot.get("fechaCita"), horarioInicio, horarioFin);
        Predicate pacientePredicate = cb.equal(citaRoot.get("paciente").get("id"), idPaciente);

        // Combinar los predicados con AND
        cq.where(cb.and(fechaPredicate, pacientePredicate));

        // Ejecutar la consulta
        return em.createQuery(cq).getResultList();
    }

    @Override
    public Optional<CitaEntity> getCita(long idCita) {
        CitaEntity cita = em.find(CitaEntity.class, idCita);
        return Optional.ofNullable(cita);
    }

    @Override
    public CitaEntity updateCita(Long idCita, CitaEntity cita) {
        // Obtener la cita existente por su ID
        CitaEntity citaExistente = em.find(CitaEntity.class, idCita);

        if (citaExistente == null) {
            throw new RuntimeException("No se encontró la cita con ID: " + idCita);
        }

        if (citaExistente.getEstatus().getIdCitaEstatus().equals(Long.parseLong(CitaEstatusEnum.CANCELADA.getValor()))){
            throw new RuntimeException("No se puede actualizar una cita que ha sido cancelada");
        }
        em.merge(cita);
        em.flush();  // Asegura que los cambios se persistan inmediatamente
        em.refresh(cita);  // Actualiza la entidad con los datos más recientes de la base de datos

        return cita;
    }

    @Override
    public CitaEntity deleteCita(Long idCita) {
        var cita = em.find(CitaEntity.class, idCita);

        if (cita == null) {
            throw new RuntimeException("Cita no encontrada con ID: " + idCita);
        }

        if (cita.getEstatus().getIdCitaEstatus().equals(Long.parseLong(CitaEstatusEnum.CANCELADA.getValor()))){
            throw new RuntimeException("Ya se ha cancelado esta cita");
        }

        var estatus = new CitaEstatusEntity();

        estatus.setIdCitaEstatus(Long.parseLong(CitaEstatusEnum.CANCELADA.getValor()));
        estatus.setEstatus(CitaEstatusEnum.CANCELADA.name());

        cita.setEstatus(estatus);

        var refreshCita = getCita(idCita);

       return refreshCita.get();

    }
}
