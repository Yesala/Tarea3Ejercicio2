package cr.ac.ucenfotec.Tarea3.bl.dao;

import cr.ac.ucenfotec.Tarea3.bl.entidades.Movimiento;
import cr.ac.ucenfotec.Tarea3.bl.entidades.RetiroAhorro;

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

public class RetiroAhorroDAO extends MovimientoDAO {

    @Override
    public boolean save(Movimiento newMovimiento) {
        ArrayList<String> lines = new ArrayList<>();
        lines.add(newMovimiento.toCSVLine());
        try {
            Files.write(Paths.get("/Users/macbook/Dev/listOfRetirosAhorros.csv"),lines, StandardCharsets.UTF_8, StandardOpenOption.CREATE,
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
        String[] retiros = null;
        try {
            reader = new BufferedReader(new FileReader("/Users/macbook/Dev/listOfRetirosAhorros.csv"));
            String currentLine;
            while((currentLine = reader.readLine()) != null) {
                retiros = currentLine.split(",");
                RetiroAhorro nuevoRetiro = new RetiroAhorro(LocalDate.parse(retiros[0]),retiros[1],Float.parseFloat(retiros[2]));
                result.add(nuevoRetiro);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
