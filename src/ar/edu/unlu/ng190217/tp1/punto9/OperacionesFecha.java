package ar.edu.unlu.ng190217.tp1.punto9;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class OperacionesFecha {
    //***METODOS PUBLICOS***
    public LocalDate unaFecha (String fecha, int formato) {
        LocalDate fechaExtraida = null;
        if ( (formato != 1) & (formato != 2) ) {System.out.println("Formato inválido.");
        } else {
            DateTimeFormatter formatos[] = {DateTimeFormatter.ofPattern("dd-MM-yyyy"),
                                            DateTimeFormatter.ofPattern("MM-dd-yyyy")};
            if (formato == 1) {fechaExtraida = LocalDate.parse(fecha, formatos[0]);
            } else {fechaExtraida = LocalDate.parse(fecha, formatos[1]);}
        }
        return fechaExtraida;
    }

    public static boolean estaEntreDos (LocalDate fechaMenor, LocalDate fechaMayor, LocalDate verificar) {return (esMenor(fechaMayor, verificar) & esMayor(fechaMenor, verificar));}

    public static boolean esMenor (LocalDate fechaMayor, LocalDate verificar) {return verificar.isBefore(fechaMayor); }

    public static boolean esMayor (LocalDate fechaMenor, LocalDate verificar) {return verificar.isAfter(fechaMenor);}
}
