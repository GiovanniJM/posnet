package posnet;

/**
 *
 * @author Giovanni Jimenez
 */

/**
 * Clase que representa un Posnet, un dispositivo utilizado para realizar pagos con tarjeta de crédito.
 * 
 * Esta clase contiene métodos para efectuar pagos y validar datos.
 */
public class Posnet {

    /** Porcentaje de recargo por cada cuota. */
    public static final double RECARGO_POR_CUOTA = 0.03;
    
    /** Cantidad mínima de cuotas permitidas. */
    public static final int MIN_CANT_CUOTAS = 1;
    
    /** Cantidad máxima de cuotas permitidas. */
    public static final int MAX_CANT_CUOTAS = 6;

    /**
     * Método que permite efectuar un pago con tarjeta de crédito.
     * 
     * @param tarjeta la tarjeta de crédito utilizada para el pago
     * @param montoAAbonar el monto a abonar
     * @param cantCuotas la cantidad de cuotas en las que se desea realizar el pago
     * @return un objeto de tipo Ticket con los detalles del pago realizado, o null si no se pudo realizar el pago
     */
    public Ticket efectuarPago(TarjetaDeCredito tarjeta, double montoAAbonar, int cantCuotas) {
        Ticket elTicket = null;

        if (datosValidos(tarjeta, montoAAbonar, cantCuotas)) {
            double montoFinal = montoAAbonar + montoAAbonar * recargoSegunCuotas(cantCuotas);
            if (tarjeta.tieneSaldoDisponible(montoFinal)) {
                tarjeta.descontar(montoFinal);
                String nomApe = tarjeta.nombreCompletoDeTitular();
                double montoPorCuota = montoFinal / cantCuotas;
                elTicket = new Ticket(nomApe, montoFinal, montoPorCuota);
            }
        }

        return elTicket;
    }

    /**
     * Método privado que valida los datos necesarios para realizar un pago.
     * 
     * @param tarjeta la tarjeta de crédito utilizada para el pago
     * @param monto el monto a abonar
     * @param cant la cantidad de cuotas en las que se desea realizar el pago
     * @return true si los datos son válidos, false en caso contrario
     */
    private boolean datosValidos(TarjetaDeCredito tarjeta, double monto, int cant) {
        boolean esTarjetaValida = tarjeta != null;
        boolean esMontoValido = monto > 0;
        boolean cantCuotasValidas = cant >= MIN_CANT_CUOTAS && cant <= MAX_CANT_CUOTAS;

        return esTarjetaValida && esMontoValido && cantCuotasValidas;
    }

    /**
     * Método privado que calcula el recargo a aplicar según la cantidad de cuotas elegida.
     * 
     * @param cantCuotas la cantidad de cuotas en las que se desea realizar el pago
     * @return el porcentaje de recargo a aplicar
     */
    private double recargoSegunCuotas(int cantCuotas) {
        return (cantCuotas - 1) * RECARGO_POR_CUOTA;
    }

}
