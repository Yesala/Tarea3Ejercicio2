package cr.ac.ucenfotec.Tarea3.controlador;

import cr.ac.ucenfotec.Tarea3.bl.entidades.*;
import cr.ac.ucenfotec.Tarea3.gestor.GestorCliente;
import cr.ac.ucenfotec.Tarea3.gestor.GestorCuenta;
import cr.ac.ucenfotec.Tarea3.gestor.GestorMovimiento;
import cr.ac.ucenfotec.Tarea3.iu.IU;

import java.time.LocalDate;
import java.util.List;

public class Controlador {

    private IU iu = new IU();
    private GestorCuenta gestorCuenta = new GestorCuenta();
    private GestorCliente gestorCliente = new GestorCliente();
    private GestorMovimiento gestorMovimiento = new GestorMovimiento();

    public void ejecutarPrograma() {
        int opcion = 0;
        do {
            iu.mostrarMenu();
            opcion = iu.leerOpcion();
            procesarOpcion(opcion);
        } while (opcion != 11);
    }

    private void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                registroCliente();
                break;
            case 2:
                listarClientes();
                break;
            case 3:
                crearCuentaAhorro();
                break;
            case 4:
                crearCuentaCorriente();
                break;
            case 5:
                crearCuentaAhorroProgramado();
                break;
            case 6:
                listarCuentas();
                break;
            case 7:
                DepositoCuentaAhorro();
                break;
            case 8:
                RetiroCuentaAhorro();
                break;
            case 9:
                DepositoCuentaCorriente();
                break;
            case 10:
                RetiroCuentaCorriente();
            case 11:
                break;
            default:
                iu.imprimirMensaje("Gracias por usar nuestros servicios");
        }
    }


    private void registroCliente() {
        iu.imprimirMensaje("Nombre completo del Cliente: ");
        String nombre = iu.leerTexto();
        iu.imprimirMensaje("Número de identificacion:");
        String identificacion = iu.leerTexto();
        iu.imprimirMensaje("Direccion exacta:");
        String direccion = iu.leerTexto();
        Cliente cliente = new Cliente(nombre, identificacion, direccion);
        this.gestorCliente.save(cliente);
    }

    private void listarClientes() {
        List<Cliente> clientes = gestorCliente.findAllClientes();
        for (Cliente unCliente: clientes) {
            iu.imprimirMensaje(unCliente.toCSVLine());
        }
    }

    private void crearCuentaAhorro() {
        iu.imprimirMensaje("Nombre completo del Cliente");
        String nombreCliente = iu.leerTexto();
        iu.imprimirMensaje("Ingresar numero de cuenta (7 dígitos)");
        String numeroCuenta = iu.leerTexto();
        iu.imprimirMensaje("Monto inicial a depositar");
        float saldo = iu.leerFloat();
        CuentaAhorro cuentaAhorro = new CuentaAhorro(nombreCliente,numeroCuenta, saldo);
        this.gestorCuenta.save(cuentaAhorro);
    }

    private void crearCuentaCorriente() {
        iu.imprimirMensaje("Nombre completo del Cliente");
        String nombreCliente = iu.leerTexto();
        iu.imprimirMensaje("Ingresar numero de cuenta (7 dígitos)");
        String numeroCuenta = iu.leerTexto();
        iu.imprimirMensaje("Monto inicial a depositar");
        float saldo = iu.leerFloat();
            if (saldo>50000.00){
                System.out.println("Monto incial correcto");
            } else {
                System.out.println("El monto mínimo inicial debe ser de 50000 colones");
            }
        CuentaCorriente cuentaCorriente = new CuentaCorriente(nombreCliente,numeroCuenta, saldo);
        this.gestorCuenta.save(cuentaCorriente);
    }

    private void crearCuentaAhorroProgramado() {
        iu.imprimirMensaje("Nombre completo del Cliente");
        String nombreCliente = iu.leerTexto();
        iu.imprimirMensaje("Ingresar numero de cuenta (7 dígitos)");
        String numeroCuenta = iu.leerTexto();
        iu.imprimirMensaje("Monto de ahorro mensual");
        float saldo = iu.leerFloat();
        CuentaAhorroProgramado ahorroProgramado = new CuentaAhorroProgramado(nombreCliente,numeroCuenta, saldo);
        this.gestorCuenta.save(ahorroProgramado);
    }

    private void listarCuentas() {
        iu.imprimirMensaje("Elija la cuenta a imprimir: 1. Ahorro, 2. Corriente, 3, Ahorro Programado");
        Cuenta tipoCuenta = new Cuenta();
        int escogencia = iu.leerEntero();
        if (escogencia == 1) {
            tipoCuenta = new CuentaAhorro();
        }
        else if (escogencia == 2) {
            tipoCuenta = new CuentaCorriente();
        }
        else if (escogencia == 3) {
            tipoCuenta = new CuentaAhorroProgramado();
        }
        List<Cuenta> cuentas = gestorCuenta.listAll(tipoCuenta);
        for (Cuenta unaCuenta: cuentas) {
            iu.imprimirMensaje(unaCuenta.toCSVLine());
        }
    }

    private LocalDate obtenerFecha(String fecha) {
        return LocalDate.parse(fecha);
    }

    private void DepositoCuentaAhorro() {
        iu.imprimirMensaje("Fecha del depósito");
        String fecha = iu.leerTexto();
        LocalDate fechaRetiro = obtenerFecha(fecha);
        iu.imprimirMensaje("Motivo del depósito ");
        String descripcion = iu.leerTexto();
        iu.imprimirMensaje("Monto del depósito");
        float monto = iu.leerFloat();
        if(monto>0){
            monto = monto + CuentaAhorro.saldo;
        }
        DepositoAhorro depositoAhorro = new DepositoAhorro(fechaRetiro, descripcion, monto);
        this.gestorMovimiento.save(depositoAhorro);
    }

    private void RetiroCuentaAhorro() {
        iu.imprimirMensaje("Fecha del retiro (*Debe ser mayor a 1 año desde la apertura de la cuenta*):");
        String fecha = iu.leerTexto();
        LocalDate fechaRetiro = obtenerFecha(fecha);
        iu.imprimirMensaje("Motivo del retiro");
        String descripcion = iu.leerTexto();
        iu.imprimirMensaje("Monto del retiro");
        float monto = iu.leerFloat();
        if (CuentaAhorro.saldo >= 100000){
            if(monto < CuentaAhorro.saldo*0.5){
                monto = CuentaAhorro.saldo - monto;
            }else{
                iu.imprimirMensaje("No se puede hacer el retiro");
            }
        }
        RetiroAhorro retiroAhorro = new RetiroAhorro(fechaRetiro, descripcion, monto);
        this.gestorMovimiento.save(retiroAhorro);
    }

    private void DepositoCuentaCorriente() {
        iu.imprimirMensaje("Fecha del depósito");
        String fecha = iu.leerTexto();
        LocalDate fechaRetiro = obtenerFecha(fecha);
        iu.imprimirMensaje("Motivo del depósito ");
        String descripcion = iu.leerTexto();
        iu.imprimirMensaje("Monto del depósito");
        float monto = iu.leerFloat();
        if(monto>0){
            monto = monto + CuentaCorriente.saldo;
        }
        DepositoCtaCorriente depositoCtaCorriente = new DepositoCtaCorriente(fechaRetiro, descripcion, monto);
        this.gestorMovimiento.save(depositoCtaCorriente);
    }

    private void RetiroCuentaCorriente() {
        iu.imprimirMensaje("Fecha del retiro:");
        String fecha = iu.leerTexto();
        LocalDate fechaRetiro = obtenerFecha(fecha);
        iu.imprimirMensaje("Motivo del retiro");
        String descripcion = iu.leerTexto();
        iu.imprimirMensaje("Monto del retiro");
        float monto = iu.leerFloat();
        if (monto<CuentaCorriente.saldo){
                monto = CuentaCorriente.saldo - monto;
            }
        RetiroCtaCorriente retiroCtaCorriente = new RetiroCtaCorriente(fechaRetiro, descripcion, monto);
        this.gestorMovimiento.save(retiroCtaCorriente);
    }

}
