package cr.ac.ucenfotec.Tarea3.bl.entidades;

import cr.ac.ucenfotec.Tarea3.bl.interfaces.SerializacionCSV;

public class Cliente implements SerializacionCSV {

    private String nombre;
    private String identificacion;
    private String direccion;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Cliente() {
    }

    public Cliente(String nombre, String identificacion, String direccion) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.direccion = direccion;
    }

    @Override
    public String toCSVLine() {
        return this.nombre + "," + this.identificacion + ", " + this.direccion + ",";
    }
}
