package posnet;

/**
 *
 * @author Giovanni Jimenez
 */

/**
 * Clase que representa a una tarjeta de crédito.
 * Contiene información sobre la entidad bancaria, número de tarjeta, saldo disponible,
 * entidad financiera y titular de la tarjeta.
 */
public class TarjetaDeCredito {

   
    private String entidadBancaria;
    private String nroTarjeta;
    private double saldo;
    private EntidadFinanciera entidadFinanciera;
    private Persona titular;

    /**
 * Constructor de la clase TarjetaDeCredito.
 * 
 * @param entidadBancaria la entidad bancaria emisora de la tarjeta
 * @param nroTarjeta el número de la tarjeta
 * @param saldo el saldo disponible en la tarjeta
 * @param titular la persona titular de la tarjeta
 * @param entidadFinanciera la entidad financiera a la que pertenece la tarjeta
 */
public TarjetaDeCredito(String entidadBancaria, String nroTarjeta, double saldo, Persona titular, EntidadFinanciera entidadFinanciera) {
    this.entidadBancaria = entidadBancaria;
    this.nroTarjeta = nroTarjeta;
    this.saldo = saldo;
    this.titular = titular;
    this.entidadFinanciera = entidadFinanciera;
}

/**
 * Verifica si la tarjeta tiene saldo disponible para realizar un pago.
 * 
 * @param monto el monto a pagar
 * @return true si el saldo de la tarjeta es mayor o igual al monto, false en caso contrario
 */
public boolean tieneSaldoDisponible(double monto) {
    return saldo >= monto;
}

/**
 * Descuenta un monto del saldo disponible de la tarjeta.
 * 
 * @param monto el monto a descontar del saldo
 */
public void descontar(double monto) {
    saldo -= monto;
}

/**
 * Devuelve el nombre completo del titular de la tarjeta.
 * 
 * @return el nombre completo del titular
 */
public String nombreCompletoDeTitular() {
    return titular.nombreCompleto();
}

/**
 * Devuelve una representación en cadena de caracteres de la tarjeta de crédito.
 * 
 * @return una representación en cadena de caracteres de la tarjeta
 */
@Override
public String toString() {
    return "TarjetaDeCredito{" + "entidadBancaria=" + entidadBancaria + ", nroTarjeta=" + nroTarjeta + ", saldo=" + saldo + ", entidadFinanciera=" + entidadFinanciera + ", titular=" + titular + '}';
}
}
