package ar.edu.unlu.ng190217.tp1.punto10;

import java.time.LocalDate;

public class Tarea2 {
    //***ATRIBUTOS***
    private int codigoTarea; //Identifica unívocamente a una tarea dentro de un AdminTarea.
    private String descripcion;
    private int prioridad;
    private boolean completa;
    private LocalDate fechaLimite;
    private LocalDate fechaRecordatorio;

    //***METODOS PRIVADOS***
    private void actualizarPrioridad () {
        if ( (fechaRecordatorio.isEqual(fechaLimite)) ||
             (fechaRecordatorio.isEqual(fechaLimite.minusDays(1))) ) {
            prioridad = 1;
        }
    }
    //***METODOS PUBLICOS***
    //***COSTRUCTORES***
    public Tarea2() {
        completa = false;
        fechaLimite = null;
    }

    public Tarea2(LocalDate fechaLimite, int codigoTarea) {
        this.codigoTarea = codigoTarea;
        completa = false;
        this.fechaLimite = fechaLimite;
    }

    public Tarea2(String descripcion, int prioridad, LocalDate fechaLimite, LocalDate fechaRecordatorio, int codigoTarea) {
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

    public void setFechaLimite(LocalDate fechaLimite) {this.fechaLimite = fechaLimite;}

    public LocalDate getFechaLimite() {return fechaLimite;}

    public int getPrioridad () {return prioridad;}

    public LocalDate getFechaRecordatorio () {return fechaRecordatorio;}

    public int getCodigo () {return codigoTarea;}

    public String getDescripcion () {return descripcion;}

    public boolean vencida () {return ( (!completa) & (LocalDate.now().isAfter(fechaLimite)) );}

    public void completar () {completa = true;}

    public boolean estaCompleta () {return completa;}

    public String toString () {
        String tarea = "";
        if (this.vencida()) {
            tarea = "(Vencida)... ";
        } else if ( (fechaRecordatorio.isEqual(LocalDate.now())) ||
                (fechaRecordatorio.isAfter(LocalDate.now())) ) {
            tarea = "(por vencer)";
        }
        tarea += descripcion;
        return tarea;
    }

    public boolean equals (Tarea2 tarea) {return codigoTarea == tarea.getCodigo();}
}
