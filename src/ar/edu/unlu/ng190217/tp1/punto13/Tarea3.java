package ar.edu.unlu.ng190217.tp1.punto13;

import java.time.LocalDate;

public class Tarea3 {
    //***ATRIBUTOS***
    private int codigoTarea; //Identifica unívocamente a una tarea dentro de un AdminTarea.
    private String descripcion;
    private int prioridad;
    private boolean completa;
    private LocalDate fechaLimite;
    private LocalDate fechaRecordatorio;
    private LocalDate fechaFinalizacion;
    private Colaborador colaborador;

    //***METODOS PUBLICOS***

    //***CONSTRUCTORES***
    public Tarea3() {
        completa = false;
        fechaLimite = null;
    }

    public Tarea3(LocalDate fechaLimite, int codigoTarea) {
        this.codigoTarea = codigoTarea;
        completa = false;
        this.fechaLimite = fechaLimite;
    }

    public Tarea3(String descripcion, int prioridad, LocalDate fechaLimite, LocalDate fechaRecordatorio, int codigoTarea) {

        this.descripcion = descripcion;
        this.prioridad = prioridad;
        completa = false;
        this.fechaLimite = fechaLimite;
        setFechaRecordatorio(fechaRecordatorio);
        this.codigoTarea = codigoTarea;

    }

    public void setDescripcion (String descripcion) {this.descripcion = descripcion;}

    public void setPrioridad (int prioridad) {this.prioridad = prioridad;}

    public void setFechaRecordatorio (LocalDate fechaRecordatorio) {
        this.fechaRecordatorio = fechaRecordatorio;
        actualizarPrioridad();
    }

    public int getPrioridad () {return prioridad;}

    public LocalDate getFechaRecordatorio () {return fechaRecordatorio;}

    public int getCodigo () {return codigoTarea;}

    public String getDescripcion () {return descripcion;}

    public boolean vencida () {return ( (!completa) & (LocalDate.now().isAfter(fechaLimite)) );}

    public void completar (Colaborador colaborador, LocalDate fechaFinalizacion) {
        completa = true;
        this.colaborador = colaborador;
        this.fechaFinalizacion = fechaFinalizacion;
    }

    public boolean estaCompleta () {return completa;}

    public void actualizarPrioridad () {
        if ( (fechaRecordatorio.isEqual(fechaLimite)) || (fechaRecordatorio.isEqual(fechaLimite.minusDays(1))) ) {
            prioridad = 1;
        }
    }

    public String toString () {
        String tarea = "";
        if (this.vencida()) {tarea = "(Vencida)... ";
        } else if ( (fechaRecordatorio.isEqual(LocalDate.now())) || (fechaRecordatorio.isAfter(LocalDate.now())) ) {
            tarea = "(por vencer)";
        }
        tarea += descripcion;
        return tarea;
    }

    public boolean equals (Tarea3 tarea) {return codigoTarea == tarea.getCodigo();}
}
