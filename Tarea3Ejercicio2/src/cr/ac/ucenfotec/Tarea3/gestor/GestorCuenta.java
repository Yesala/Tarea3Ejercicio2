package cr.ac.ucenfotec.Tarea3.gestor;

import cr.ac.ucenfotec.Tarea3.bl.dao.*;
import cr.ac.ucenfotec.Tarea3.bl.entidades.*;

import java.util.ArrayList;
import java.util.List;

public class GestorCuenta {

    protected CuentaDAO CuentaAhorroDAO = new CuentaAhorroDAO();
    private CuentaDAO CuentaCorrienteDAO = new CuentaCorrienteDAO();
    private CuentaDAO CuentaAhorroProgramadoDAO = new CuentaAhorroProgramadoDAO();

    public boolean save(Cuenta nuevaCuenta){
        try{
            CuentaDAO objPersistente = determinarObjetoDAO(nuevaCuenta);
            return objPersistente.save(nuevaCuenta);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    private CuentaDAO determinarObjetoDAO(Cuenta nuevaCuenta) throws Exception {
        if(nuevaCuenta instanceof CuentaAhorro){
            return this.CuentaAhorroDAO;
        }
        if(nuevaCuenta instanceof CuentaCorriente){
            return this.CuentaCorrienteDAO;
        }
        if(nuevaCuenta instanceof CuentaAhorroProgramado){
            return this.CuentaAhorroProgramadoDAO;
        }
        throw new Exception("Opción Desconocida");
    }

    public List<Cuenta> listAll(Cuenta tipo){
        try{
            CuentaDAO objPersistente = determinarObjetoDAO(tipo);
            return objPersistente.findAll();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return new ArrayList<Cuenta>();
    }

}
