public class TicketMachine {

    public void buyTicket(Passenger passenger, int ticketValidityTime){
        Ticket ticket = new Ticket(ticketValidityTime);
        passenger.setTicket(ticket);
    }
}
