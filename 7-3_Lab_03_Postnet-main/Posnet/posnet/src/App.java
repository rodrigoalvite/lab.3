import dominio.Posnet;
import dominio.TarjetaDeCredito;
import dominio.Ticket;

public class App {
    public static void main(String[] args) throws Exception {
        TarjetaDeCredito tarjeta = new TarjetaDeCredito("Banco Nacion", "5348-4769", 15000.0);
        Posnet posnet = new Posnet();
        Ticket ticket = posnet.efectuarPago(tarjeta, 10000.0, 5);
        System.out.println(ticket.getNombre() + " " + ticket.getApellido());
        System.out.println(ticket.getMontoTotal());
        System.out.println(ticket.getMontoCuota());
    }
}