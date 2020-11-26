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

public class CuentaAhorroProgramadoDAO extends CuentaDAO {
    @Override
    public boolean save(Cuenta newCuenta) {
        ArrayList<String> lines = new ArrayList<>();
        lines.add(newCuenta.toCSVLine());
        try {
            Files.write(Paths.get("/Users/macbook/Dev/listOfCuentaAhorroProgramado.csv"),lines, StandardCharsets.UTF_8, StandardOpenOption.CREATE,
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
        String[] programado = null;
        try {
            reader = new BufferedReader(new FileReader("/Users/macbook/Dev/listOfCuentaAhorroProgramado.csv"));
            String currentLine;
            while((currentLine = reader.readLine()) != null) {
                programado = currentLine.split(",");
                CuentaAhorro nuevaCuentaAhorro = new CuentaAhorro(programado[0],programado[1],Float.parseFloat(programado[2]));
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
