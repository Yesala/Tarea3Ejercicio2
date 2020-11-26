package cr.ac.ucenfotec.Tarea3.bl.entidades;


public class CuentaCorriente extends Cuenta {

    public CuentaCorriente() {
    }

    public CuentaCorriente(String nombreCliente, String numeroCuenta, float saldo) {
        super(nombreCliente, numeroCuenta, saldo);
    }

    @Override
    public String toCSVLine() {
        return this.nombreCliente + "," + this.numeroCuenta + ", " + this.saldo + ",";

    }
}
