package cr.ac.ucenfotec.Tarea3.bl.entidades;

public class CuentaAhorro extends Cuenta{

    private static float tasaInteres = (float) 0.3;

    public CuentaAhorro() {
    }

    public CuentaAhorro(String nombreCliente, String numeroCuenta, float saldo) {
        super(nombreCliente, numeroCuenta, saldo);
    }

    @Override
    public String toCSVLine() {
        return  this.nombreCliente + "," + this.numeroCuenta + "," + this.saldo + ",";
    }
}
