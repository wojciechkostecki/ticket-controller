import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Scanner;

public class TicketController {
    public static void main(String[] args) throws ParseException {
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

    private static Passenger[] validateTickets(Passenger[] passengers) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Data i godzina kontroli w formacie: yyyy-MM-dd HH:mm");
        String date = scanner.nextLine();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date controlDate = sdf.parse(date);

        int ticketExpirationDate = 0;

        for (Passenger passenger : passengers) {
            LocalDateTime ticketDate = passenger.getTicket().getPurchaseDate().
                    plusMinutes(passenger.getTicket().getValidFor());
            Date ticketExpiryDate = Date.from(ticketDate.atZone(ZoneId.systemDefault()).toInstant());
            if (controlDate.after(ticketExpiryDate)) {
                ticketExpirationDate++;
            }
        }

        Passenger[] withoutTicket = new Passenger[ticketExpirationDate];

        for (int i = 0, j = 0; i < passengers.length; i++) {
            LocalDateTime ticketDate = passengers[i].getTicket().getPurchaseDate().
                    plusMinutes(passengers[i].getTicket().getValidFor());
            Date ticketExpiryDate = Date.from(ticketDate.atZone(ZoneId.systemDefault()).toInstant());
            if (controlDate.after(ticketExpiryDate)) {
                withoutTicket[j] = passengers[i];
                j++;
            }
        }
        return withoutTicket;
    }

    private static void printPassengerWithoutTicket(Passenger[] passengers) {
        System.out.println("Pasażerowie bez biletu: ");
        for (Passenger passenger : passengers) {
            System.out.println(passenger.getFirstName() + " " + passenger.getLastName());
        }
    }
}

