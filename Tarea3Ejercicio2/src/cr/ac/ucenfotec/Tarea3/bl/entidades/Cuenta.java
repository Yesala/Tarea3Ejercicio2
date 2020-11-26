package cr.ac.ucenfotec.Tarea3.bl.entidades;

import cr.ac.ucenfotec.Tarea3.bl.interfaces.SerializacionCSV;

public class Cuenta implements SerializacionCSV {

    protected String nombreCliente;
    protected String numeroCuenta;
    public static float saldo = 0;

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public Cuenta() {
    }

    public Cuenta(String nombreCliente, String numeroCuenta, float saldo) {
        this.nombreCliente = nombreCliente;
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
    }

    @Override
    public String toCSVLine() {
        return  this.nombreCliente + "," + this.numeroCuenta + "," + this.saldo + ",";
    }

}
