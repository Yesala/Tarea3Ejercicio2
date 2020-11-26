package cr.ac.ucenfotec.Tarea3.bl.dao;

import cr.ac.ucenfotec.Tarea3.bl.entidades.Cuenta;

import java.util.List;

public abstract class CuentaDAO {

    public abstract boolean save(Cuenta newCuenta);
    public abstract List<Cuenta> findAll();

}
