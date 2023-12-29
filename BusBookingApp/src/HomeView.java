import java.util.Scanner;

public class HomeView {
    static Scanner sc = new Scanner(System.in);
    void start(){
        CentralViewModel vm = new CentralViewModel(this);
        boolean loop = true;
        while(loop){
            System.out.println("1. Book ticket\n" +
                    "2. Show specific tickets details.\n" +
                    "3. Booked seats \n" +
                    "4. Empty seats\n" +
                    "5. Cancel ticket\n" +
                    "6. All tickets");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1:{
                    System.out.println("Available Tickets...");
                    vm.availableSeats();
                    System.out.println("Enter number of seats: ");
                    int numOfSeat = sc.nextInt();
                    sc.nextLine();
                    vm.bookSeats(numOfSeat);
                    break;
                }
                case 2:{
                    System.out.println("Enter ticket id: ");
                    vm.showTicketDetails(sc.nextInt());
                    sc.nextLine();
                    break;
                }
                case 3:{
                    System.out.println("All booked seats are...");
                    vm.bookedSeats();
                    break;
                }
                case 4:{
                    System.out.println("All available seats are...");
                    vm.availableSeats();
                    break;
                }
                case 5:{
                    System.out.println("Enter ticket id needed to be cancelled...");
                    int ticketId = sc.nextInt();
                    sc.nextLine();
                    vm.cancelTicket(ticketId);
                    break;
                }
                case 6:{
                    vm.showTickets();
                    break;
                }
                default:{
                    System.out.println("Please enter valid input...");
                }
            }
        }


    }
}
