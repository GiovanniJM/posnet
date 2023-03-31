package posnet;

/**
 *
 * @author Giovanni Jimenez
 */

/**
 * Clase que representa un ticket de pago.
 * Contiene información sobre el nombre y apellido del titular de la tarjeta,
 * el monto total del pago y el monto por cuota en caso de haberse efectuado el pago en cuotas.
 * Además, tiene un método toString() que devuelve una representación en String del ticket.
 */

public class Ticket {

private String nombreApellido;
private double montoTotal;
private double montoPorCuota;

/**

Constructor de la clase Ticket.
@param nombreApellido el nombre y apellido del titular de la tarjeta
@param montoTotal el monto total del pago
@param montoPorCuota el monto por cuota en caso de haberse efectuado el pago en cuotas
*/
public Ticket(String nombreApellido, double montoTotal, double montoPorCuota) {
this.nombreApellido = nombreApellido;
this.montoTotal = montoTotal;
this.montoPorCuota = montoPorCuota;
}
/**

Devuelve una representación en String del ticket.
@return una cadena de texto que contiene la información del ticket
*/
@Override
public String toString() {
return "Ticket{" + "nombreApellido=" + nombreApellido + ", montoTotal=" + montoTotal + ", montoPorCuota=" + montoPorCuota + '}';
}
}
