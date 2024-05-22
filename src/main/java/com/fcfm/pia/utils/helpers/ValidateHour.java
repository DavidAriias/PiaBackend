package com.fcfm.pia.utils.helpers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateHour {
    public static boolean validarFormatoHora(String inputStr) {
        // Patrón regex para HH:mm
        String patron = "([01]?[0-9]|2[0-3]):[0-5][0-9]";

        // Compilar el patrón regex
        Pattern pattern = Pattern.compile(patron);

        // Crear un matcher para el inputStr
        Matcher matcher = pattern.matcher(inputStr);

        // Verificar si el inputStr coincide con el patrón
        return matcher.matches();
    }
}
