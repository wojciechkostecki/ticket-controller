public class TicketController {
    public static void main(String[] args) {
        TicketMachine ticketMachine = new TicketMachine();

        Passenger[] passengers = new Passenger[3];
        passengers[0] = new Passenger("Wojciech","Kostecki");
        passengers[1] = new Passenger("Rafał","Bobko");
        passengers[2] = new Passenger("Damian","Podbilski");

        ticketMachine.buyTicket(passengers[0], 30);
        ticketMachine.buyTicket(passengers[1], 20);
        ticketMachine.buyTicket(passengers[2], 15);
    }
}
