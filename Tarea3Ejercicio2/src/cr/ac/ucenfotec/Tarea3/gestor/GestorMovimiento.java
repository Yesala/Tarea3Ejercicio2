package cr.ac.ucenfotec.Tarea3.gestor;

import cr.ac.ucenfotec.Tarea3.bl.dao.*;
import cr.ac.ucenfotec.Tarea3.bl.entidades.*;

import java.util.ArrayList;
import java.util.List;

public class GestorMovimiento {

    private MovimientoDAO RetiroAhorroDAO = new RetiroAhorroDAO();
    private MovimientoDAO DepositoAhorroDAO = new DepositoAhorroDAO();
    private MovimientoDAO RetiroCuentaCorrienteDAO = new DepositoCuentaCorrienteDAO();
    private MovimientoDAO DepositoCuentaCorrienteDAO = new DepositoCuentaCorrienteDAO();

    public boolean save(Movimiento nuevoMovimiento){
        try{
            MovimientoDAO objPersistente = determinarObjetoDAO(nuevoMovimiento);
            return objPersistente.save(nuevoMovimiento);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    private MovimientoDAO determinarObjetoDAO(Movimiento nuevoMovimiento) throws Exception {
        if(nuevoMovimiento instanceof RetiroAhorro){
            return this.RetiroAhorroDAO;
        }
        if(nuevoMovimiento instanceof DepositoAhorro){
            return this.DepositoAhorroDAO;
        }
        if(nuevoMovimiento instanceof DepositoCtaCorriente){
            return this.DepositoCuentaCorrienteDAO;
        }
        if(nuevoMovimiento instanceof RetiroCtaCorriente){
            return this.RetiroCuentaCorrienteDAO;
        }
        throw new Exception("Opción Desconocida");
    }

    public List<Movimiento> listAll(Movimiento tipo){
        try{
            MovimientoDAO objPersistente = determinarObjetoDAO(tipo);
            return objPersistente.findAll();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return new ArrayList<Movimiento>();
    }




}
