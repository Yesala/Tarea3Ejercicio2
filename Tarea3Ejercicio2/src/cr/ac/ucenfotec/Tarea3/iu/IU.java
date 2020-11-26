package cr.ac.ucenfotec.Tarea3.iu;

import java.io.PrintStream;
import java.util.Scanner;

public class IU {

    private PrintStream output = new PrintStream(System.out);
    private Scanner input = new Scanner(System.in).useDelimiter("\n");

    public void mostrarMenu() {
        output.println("Bienvenido al Banco Corporativo");
        output.println("1. Registro de cliente");
        output.println("2. Listar clientes");
        output.println("3. Crear cuenta de ahorro");
        output.println("4. Crear cuenta corriente");
        output.println("5. Crear cuenta de ahorro programado");
        output.println("6. Listar según tipo de cuenta");
        output.println("7. Depósito Cuenta Ahorros");
        output.println("8. Retiro Cuenta Ahorros");
        output.println("9. Deposito Cuenta Corriente");
        output.println("10. Retiro Cuenta Corriente");
        output.println("11. Salir");
    }

    public int leerOpcion() {
        output.println("Opción seleccionada: ");
        return input.nextInt();
    }

    public void imprimirMensaje(String mensaje) {
        output.println(mensaje);
    }

    public String leerTexto() {
        return input.next();
    }

    public int leerEntero() {
        return input.nextInt();
    }

    public float leerFloat() {
        return input.nextFloat();
    }


}
