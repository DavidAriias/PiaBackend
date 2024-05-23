package com.fcfm.pia.models.enums;

public enum CitaEstatusEnum {
    AGENDADA("1"),
    REPROGRAMADA("2"),
    CANCELADA("3");

    private final String valor;

    // Constructor del enum
    CitaEstatusEnum(String valor) {
        this.valor = valor;
    }

    // Método para obtener el valor numérico del estatus
    public String getValor() {
        return valor;
    }
}

