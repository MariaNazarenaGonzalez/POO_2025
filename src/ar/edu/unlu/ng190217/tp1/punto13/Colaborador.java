package ar.edu.unlu.ng190217.tp1.punto13;

import java.util.ArrayList;

public class Colaborador {
    //***ATRIBUTOS***
    private String razonSocial;
    private ArrayList<Tarea3> tareasRealizadas;

    //***METODOS PUBLICOS***
    public Colaborador (String razonSocial) {
        this.razonSocial = razonSocial;
        tareasRealizadas = new ArrayList<Tarea3>();
    }

    public void setRazonSocial (String razonSocial) {this.razonSocial = razonSocial;}

    public String getRazonSocial () {return razonSocial;}

    public  ArrayList<Tarea3> getTareas () {return tareasRealizadas;}

    public void registrarTarea (Tarea3 tarea) {tareasRealizadas.add(tarea);}

    public String toString () {
        String aMostrar = "\nEl colaborador: " + razonSocial + "\nRealizo las tareas: ";
        for (Tarea3 tarea: tareasRealizadas) {aMostrar = aMostrar.concat("\n-" + tarea.getDescripcion());}
        return aMostrar;
    }
}
