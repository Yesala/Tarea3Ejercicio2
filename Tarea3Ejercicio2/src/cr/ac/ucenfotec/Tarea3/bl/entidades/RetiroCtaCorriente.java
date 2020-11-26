package cr.ac.ucenfotec.Tarea3.bl.entidades;

import java.time.LocalDate;

public class RetiroCtaCorriente extends Movimiento {

    public RetiroCtaCorriente() {
    }

    public RetiroCtaCorriente(LocalDate fecha, String descripcion, Float monto) {
        super(fecha, descripcion, monto);
    }

    @Override
    public String toCSVLine() {
        return this.fecha + "," + this.descripcion + "," + this.monto + ",";
    }
}
