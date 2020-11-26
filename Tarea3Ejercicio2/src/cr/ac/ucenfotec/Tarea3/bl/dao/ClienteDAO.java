package cr.ac.ucenfotec.Tarea3.bl.dao;

import cr.ac.ucenfotec.Tarea3.bl.entidades.Cliente;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    public boolean save(Cliente nuevoCliente) {
        ArrayList<String> lines = new ArrayList<>();
        lines.add(nuevoCliente.toCSVLine());
        try {
            Files.write(Paths.get("/Users/macbook/Dev/listOfClientes.csv"),lines, StandardCharsets.UTF_8, StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }


    public List<Cliente> getAll(){
        ArrayList<Cliente> result = new ArrayList<>();
        BufferedReader reader;
        String[] clientes = null;
        try {
            reader = new BufferedReader(new FileReader("/Users/macbook/Dev/listOfClientes.csv"));
            String currentLine;
            while((currentLine = reader.readLine()) != null) {
                clientes = currentLine.split(",");
                Cliente nuevoCliente = new Cliente(clientes[0], clientes[1],clientes[2]);
                result.add(nuevoCliente);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

}
