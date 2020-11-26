package cr.ac.ucenfotec.Tarea3.bl.entidades;

import java.time.LocalDate;

public class DepositoAhorro extends Movimiento {

    public DepositoAhorro() {
    }

    public DepositoAhorro(LocalDate fecha, String descripcion, Float monto) {
        super(fecha, descripcion, monto);
    }

    @Override
    public String toCSVLine() {
        return this.fecha + ", " + this.descripcion + "," + this.monto + ",";
    }
}
