import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CentralViewModel {
    HomeView homeView;
    static Scanner sc = new Scanner(System.in);
    static int id=0;
    static BusModel busModel = BusModel.getInstance();
    CentralViewModel(HomeView homeView){
        this.homeView = homeView;
    }
    void availableSeats(){
        System.out.println("Sitter seats: "+busModel.sitterSeats);
        System.out.println("Single sleeper seats: "+busModel.singleSleeperSeats);
        System.out.println("Double sleeper seats: "+busModel.doubleSleeperSeats);
    }

    void bookSeats(int numOfSeats){
        id++;
        System.out.println("Seat numbers => css<num> for sitters, " +
                "sss<num> for single sleeper, "+"dss<num> for double sleeper");
        List<String> totalSeatsBooked = new ArrayList<>();
        for(int i=0;i<numOfSeats;i++){
            String temp = sc.next();
            totalSeatsBooked.add(temp);
            int tempInt = Integer.parseInt(""+temp.charAt(3))-1;
            if(busModel.sitterSeats.size()>tempInt && temp.substring(0,3).equals("css")){
                busModel.sitterSeats.remove(tempInt);
                busModel.sitterSeats.add(tempInt,0);
            }
            else if(busModel.singleSleeperSeats.size()>tempInt && temp.substring(0,3).equals("sss")){
                busModel.singleSleeperSeats.remove(tempInt);
                busModel.singleSleeperSeats.add(tempInt,0);
            }
            else if(busModel.doubleSleeperSeats.size()>tempInt ){
                busModel.doubleSleeperSeats.remove(tempInt);
                busModel.doubleSleeperSeats.add(tempInt,0);
            }
        }
        busModel.entry.put(id,totalSeatsBooked);
        sc.nextLine();
    }

    void showTicketDetails(int ticketId){
        if(busModel.entry.containsKey(ticketId)){
            System.out.println(busModel.entry.get(ticketId));
        }
        System.out.println("Please enter valid ticket id....");
    }

    void bookedSeats(){
        // sitter seats
        System.out.println("Booked sitter seats: ");
        for(int i=0;i<busModel.sitterSeats.size();i++){
            if(busModel.sitterSeats.get(i)==0)
                System.out.print(i+1+" ");
        }
        System.out.println();

        // single sleeper seats
        System.out.println("Booked single sleeper seats: ");
        for(int i=0;i<busModel.singleSleeperSeats.size();i++){
            if(busModel.singleSleeperSeats.get(i)==0){
                System.out.print(i+1+" ");
            }
        }
        System.out.println();

        // double sleeper seats
        System.out.println("Booked double sleeper seats: ");
        for(int i=0;i<busModel.doubleSleeperSeats.size();i++){
            if(busModel.doubleSleeperSeats.get(i)==0){
                System.out.print(i+1+ " ");
            }
        }
        System.out.println();
    }

    void cancelTicket(int ticketId){
        if(!busModel.entry.containsKey(ticketId)){
            System.out.println("No ticket found...");
            return;
        }
        List<String> seatNums = busModel.entry.get(ticketId);
        for(int i=0;i<seatNums.size();i++){
            int tempInt = Integer.parseInt(""+seatNums.get(i).charAt(3))-1;
            if(seatNums.get(i).startsWith("css")){
                busModel.sitterSeats.remove(tempInt);
                busModel.sitterSeats.add(tempInt);
            }
            else if(seatNums.get(i).startsWith("sss")){
                busModel.singleSleeperSeats.remove(tempInt);
                busModel.singleSleeperSeats.add(tempInt);
            }
            else {
                busModel.doubleSleeperSeats.remove(tempInt);
                busModel.doubleSleeperSeats.add(tempInt);
            }
        }
        System.out.println("Tickets are cancelled successfully...");
    }
    void showTickets(){
        for(Map.Entry<Integer, List<String>> temp:busModel.entry.entrySet()){
            System.out.println("Ticket Id: "+temp.getKey()+" | Seats Detail: "+temp.getValue());
        }
    }
}
