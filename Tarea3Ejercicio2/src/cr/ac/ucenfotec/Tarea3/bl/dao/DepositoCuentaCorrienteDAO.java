package cr.ac.ucenfotec.Tarea3.bl.dao;

import cr.ac.ucenfotec.Tarea3.bl.entidades.DepositoAhorro;
import cr.ac.ucenfotec.Tarea3.bl.entidades.DepositoCtaCorriente;
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

public class DepositoCuentaCorrienteDAO extends MovimientoDAO {
    @Override
    public boolean save(Movimiento newMovimiento) {
        ArrayList<String> lines = new ArrayList<>();
        lines.add(newMovimiento.toCSVLine());
        try {
            Files.write(Paths.get("/Users/macbook/Dev/listOfDepositoCtaCorriente.csv"),lines, StandardCharsets.UTF_8, StandardOpenOption.CREATE,
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
        String[] depositoCtaCorriente = null;
        try {
            reader = new BufferedReader(new FileReader("/Users/macbook/Dev/listOfDepositoCtaCorriente.csv"));
            String currentLine;
            while((currentLine = reader.readLine()) != null) {
                depositoCtaCorriente = currentLine.split(",");
                DepositoCtaCorriente nuevoDeposito = new DepositoCtaCorriente(LocalDate.parse(depositoCtaCorriente[0]),depositoCtaCorriente[1],Float.parseFloat(depositoCtaCorriente[2]));
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
