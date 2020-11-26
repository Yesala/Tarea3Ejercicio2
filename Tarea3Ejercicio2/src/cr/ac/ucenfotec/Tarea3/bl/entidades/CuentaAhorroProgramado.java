package cr.ac.ucenfotec.Tarea3.bl.entidades;

public class CuentaAhorroProgramado extends CuentaCorriente {

    public CuentaAhorroProgramado() {
    }

    public CuentaAhorroProgramado(String nombreCliente, String numeroCuenta, float saldo) {
        super(nombreCliente, numeroCuenta, saldo);
    }

    @Override
    public String toCSVLine() {
        return this.nombreCliente + "," + this.numeroCuenta + ", " + this.saldo + ",";

    }
}
