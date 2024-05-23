package com.fcfm.pia.models.request;


public class CitaRequest {

    private Long idMedico;
    private Long idPaciente;
    private String horario;

    public CitaRequest(Long idMedico, Long idEstatus, Long idPaciente, String horario){
        this.idMedico = idMedico;
        this.idPaciente = idPaciente;
        this.horario = horario;
    }
    public Long getIdMedico() {
        return idMedico;
    }

    public Long getIdPaciente() {
        return idPaciente;
    }

    public String getHorario() {
        return horario;
    }

    public void setIdMedico(Long idMedico) {
        this.idMedico = idMedico;
    }

    public void setIdPaciente(Long idPaciente) {
        this.idPaciente = idPaciente;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
}
