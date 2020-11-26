package cr.ac.ucenfotec.Tarea3.bl.entidades;

import cr.ac.ucenfotec.Tarea3.bl.interfaces.SerializacionCSV;

import java.time.LocalDate;

public class Movimiento implements SerializacionCSV {

    protected LocalDate fecha;
    protected String descripcion;
    protected Float monto;

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Float getMonto() {
        return monto;
    }

    public void setMonto(Float monto) {
        this.monto = monto;
    }

    public Movimiento() {
    }

    public Movimiento(LocalDate fecha, String descripcion, Float monto) {
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.monto = monto;
    }

    @Override
    public String toCSVLine() {
        return this.fecha + "," + this.descripcion + "," + this.monto + ",";
    }
}
