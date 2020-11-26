package cr.ac.ucenfotec.Tarea3.bl.dao;

import cr.ac.ucenfotec.Tarea3.bl.entidades.Cuenta;
import cr.ac.ucenfotec.Tarea3.bl.entidades.Movimiento;

import java.util.List;

public abstract class MovimientoDAO {

    public abstract boolean save(Movimiento newMovimiento);
    public abstract List<Movimiento> findAll();

}
