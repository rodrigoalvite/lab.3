package dominio;

public class Posnet {
    public final double RECARGO_CUOTA = 0.03; //3% de recargo por cada cuota extra
    public final Integer MIN_CUOTA = 1; //mínimo 1 cuota
    public final Integer MAX_CUOTA = 6; //máximo 6 cuotas
  
    
    public Ticket efectuarPago(TarjetaDeCredito tarjetaCredito, double monto, int cantidadCuotas) {
        Ticket ticket = null;

        //verifica que la targeta exista que sea mayor a 0 y que las cuotas esten entre 1 y 6
        if(datosValidos(tarjetaCredito, monto, cantidadCuotas)) {
            //aplica interes por cuota
            double montoTotal = monto + monto * recargoCuotas(cantidadCuotas);
            //si la targeta tiene saldo suficiente 
            if(tarjetaCredito.getSaldo() >= montoTotal) {
                tarjetaCredito.setSaldo(tarjetaCredito.getSaldo() - montoTotal);
                ticket = new Ticket("Luca", "Bagnato Fraboschi", montoTotal, montoTotal / cantidadCuotas);
            } 
        }
        return ticket;
    }
    //controla que este todo bien
    private boolean datosValidos(TarjetaDeCredito tarjetaCredito, double monto, int cantidadCuotas) {
        boolean tarjetaValida = tarjetaCredito != null;
        boolean montoValido = monto > 0;
        boolean cuotaValida = cantidadCuotas >= MIN_CUOTA && cantidadCuotas <= MAX_CUOTA;
        return tarjetaValida && montoValido && cuotaValida;
    }
    //Calcula el interés
    private double recargoCuotas(int cuotas) {
        return (cuotas - 1) * RECARGO_CUOTA;
    }
}
