package cr.ac.ucenfotec.Tarea3.bl.dao;

import cr.ac.ucenfotec.Tarea3.bl.entidades.DepositoAhorro;
import cr.ac.ucenfotec.Tarea3.bl.entidades.Movimiento;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DepositoAhorroDAO extends MovimientoDAO {

    @Override
    public boolean save(Movimiento newMovimiento) {
        ArrayList<String> lines = new ArrayList<>();
        lines.add(newMovimiento.toCSVLine());
        try {
            Files.write(Paths.get("/Users/macbook/Dev/listOfDepositoAhorros.csv"),lines, StandardCharsets.UTF_8, StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Movimiento> findAll() {
        ArrayList<Movimiento> result = new ArrayList<>();
        BufferedReader reader;
        String[] depositoAhorro = null;
        try {
            reader = new BufferedReader(new FileReader("/Users/macbook/Dev/listOfDepositoAhorros.csv"));
            String currentLine;
            while((currentLine = reader.readLine()) != null) {
                depositoAhorro = currentLine.split(",");
                DepositoAhorro nuevoDeposito = new DepositoAhorro(LocalDate.parse(depositoAhorro[0]),depositoAhorro[1],Float.parseFloat(depositoAhorro[2]));
                result.add(nuevoDeposito);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
