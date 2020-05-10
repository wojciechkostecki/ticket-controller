import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class TicketController {
    public static void main(String[] args) {
        TicketMachine ticketMachine = new TicketMachine();

        Passenger[] passengers = new Passenger[3];
        passengers[0] = new Passenger("Wojciech", "Kostecki");
        passengers[1] = new Passenger("Rafał", "Bobko");
        passengers[2] = new Passenger("Damian", "Podbilski");

        ticketMachine.buyTicket(passengers[0], 30);
        ticketMachine.buyTicket(passengers[1], 20);
        ticketMachine.buyTicket(passengers[2], 15);

        printPassengerWithoutTicket(validateTickets(passengers));
    }

    private static Passenger[] validateTickets(Passenger[] passengers) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Data i godzina kontroli w formacie: yyyy-MM-dd HH:mm");
        String date = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime controlDate = LocalDateTime.parse(date,formatter);

        List<Passenger> passengerList = Arrays.asList(passengers);
        List<Passenger> withoutTicketList = new ArrayList<>();
        for (Passenger passenger : passengerList) {
            LocalDateTime ticketDate = passenger.getTicket().getPurchaseDate().plusMinutes(passenger.getTicket().getValidFor());
            if(controlDate.isAfter(ticketDate)){
                withoutTicketList.add(passenger);
            }
        }

        Passenger[] withoutTicket = new Passenger[withoutTicketList.size()];
        return withoutTicketList.toArray(withoutTicket);
    }

    private static void printPassengerWithoutTicket(Passenger[] passengers) {
        System.out.println("Pasażerowie bez biletu: ");
        for (Passenger passenger : passengers) {
            System.out.println(passenger.getFirstName() + " " + passenger.getLastName());
        }
    }
}

