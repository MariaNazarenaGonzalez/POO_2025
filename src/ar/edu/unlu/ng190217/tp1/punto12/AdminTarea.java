package ar.edu.unlu.ng190217.tp1.punto12;

import ar.edu.unlu.ng190217.tp1.punto10.Tarea2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

public class AdminTarea {
    //***ATRIBUTOS***
    private ArrayList<Tarea2> tareas;
    int asignadorCodigo; //Se utiliza para asignar un código único a las tareas dentro de tareas

    //***METODOS PRIVADOS***

    private boolean esTareaValida (Tarea2 tarea, ArrayList<Tarea2> tareasProcesadas) {
        boolean esValida = true;
        if (!tareasProcesadas.isEmpty()) {
            for (Tarea2 tarea2 : tareasProcesadas) {
                if (tarea.equals(tarea2)) {esValida = false;}
            }
        }
        if (tarea.vencida()) {esValida = false;}
        return esValida;
    }

    private void intercambiarTareas (ArrayList<Tarea2> tareas, int i) {
        if (tareas.get(i).getPrioridad() < tareas.get(i-1).getPrioridad()) {
            Collections.swap(tareas, i, i-1);
        } else if (tareas.get(i).getPrioridad() == tareas.get(i-1).getPrioridad()) {
            if (tareas.get(i).getFechaRecordatorio().isBefore(tareas.get(i-1).getFechaRecordatorio())) {
                Collections.swap(tareas, i, i-1);
            }
        }
    }

    private void ordenarTareas (ArrayList<Tarea2> tareas) {
        for (int i = 0; i < (int) tareas.size(); i++) {
            for (int j = 1; j < (int) tareas.size() - i; j++) {
                intercambiarTareas(tareas, j);
            }
        }
    }

    //***METODOS PUBLICOS***
    //***CONSTRUCTOR***
    public AdminTarea () {
        tareas = new ArrayList<Tarea2>();
        asignadorCodigo = 0;
    }

    public void crearTarea (LocalDate fechaLimite) {
        asignadorCodigo++;
        tareas.add(new Tarea2(fechaLimite, asignadorCodigo));
    }
    public void crearTarea (String descripcion, int prioridad, LocalDate fechaLimite, LocalDate fechaRecordatorio) {
        asignadorCodigo++;
        tareas.add(new Tarea2(descripcion, prioridad, fechaLimite, fechaRecordatorio, asignadorCodigo));
    }

    public ArrayList<Tarea2> tareasOrdenadas () {
        ArrayList<Tarea2> tareasEnOrden = new ArrayList<Tarea2>();
        //La resolución de conflictos según prioridad se resuelve mediante fecha de vencimiento
        for (Tarea2 tarea : tareas) {
            if (esTareaValida(tarea, tareasEnOrden)) {tareasEnOrden.add(tarea);}
        }
        ordenarTareas(tareasEnOrden);
        return tareasEnOrden;
    }

    public void marcarTareaNCompletada (int n) {
        if ((n < 1) | (n > tareas.size())) {System.out.println("Número de tarea no válido.");
        } else {tareas.get(n-1).completar();}
    }

    public Tarea2 buscarTareaPorTitulo (String titulo) {
        Tarea2 tareaBuscada = null;
        Tarea2 tarea;
        int i = 0;
        while ( (tareaBuscada == null) & (i < tareas.size())) {
            tarea = tareas.get(i);
            if (tarea.getDescripcion().equals(titulo)) {tareaBuscada = tarea;}
            i++;
        }
        return tareaBuscada;
    }
}
