package cr.ac.ucenfotec.Tarea3.gestor;

import cr.ac.ucenfotec.Tarea3.bl.dao.ClienteDAO;
import cr.ac.ucenfotec.Tarea3.bl.entidades.Cliente;

import java.util.List;

public class GestorCliente {

    private ClienteDAO clienteDAO = new ClienteDAO();

    public void save(Cliente cliente) {
        clienteDAO.save(cliente);
    }

    public List<Cliente> findAllClientes() {
        return clienteDAO.getAll();
    }


}
