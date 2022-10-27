
public class ListaTickets {

	private TicketVuelo listaTickets[];
	private int cantTickets;
	private int max;
	
	public ListaTickets(int max) {
		
		listaTickets = new TicketVuelo[max];
		cantTickets = 0;
		this.max = max;
	}
	
	public boolean agregarTicket(TicketVuelo ticket) {
		if(cantTickets < max) {
			listaTickets[cantTickets] = ticket;
			cantTickets++;
			return true;
		}else {
			
			return false;
		}
	}
	
	public int getTotalVenta() {
		
		int total = 0;
		
		for(int i = 0; i < cantTickets; i++) {
			total = total + listaTickets[i].getValor();
		}
		
		return total;
		
	}
}
