package cr.ac.ucenfotec.Tarea3.bl.dao;

import cr.ac.ucenfotec.Tarea3.bl.entidades.Cuenta;
import cr.ac.ucenfotec.Tarea3.bl.entidades.CuentaAhorro;

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

public class CuentaCorrienteDAO extends CuentaDAO {

    @Override
    public boolean save(Cuenta newCuenta) {
        ArrayList<String> lines = new ArrayList<>();
        lines.add(newCuenta.toCSVLine());
        try {
            Files.write(Paths.get("/Users/macbook/Dev/listOfCuentaCorriente.csv"),lines, StandardCharsets.UTF_8, StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Cuenta> findAll() {
        ArrayList<Cuenta> result = new ArrayList<>();
        BufferedReader reader;
        String[] corriente = null;
        try {
            reader = new BufferedReader(new FileReader("/Users/macbook/Dev/listOfCuentaCorriente.csv"));
            String currentLine;
            while((currentLine = reader.readLine()) != null) {
                corriente = currentLine.split(",");
                CuentaAhorro nuevaCuentaAhorro = new CuentaAhorro(corriente[0],corriente[1],Float.parseFloat(corriente[2]));
                result.add(nuevaCuentaAhorro);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
    }