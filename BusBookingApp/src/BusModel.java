import java.util.*;
//singleton class
public class BusModel {
    private static BusModel busModel;
    public static BusModel getInstance(){
        if(busModel == null){
            busModel = new BusModel();
        }
        return busModel;
    }
    // Number of seats
    List<Integer> sitterSeats = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,7,8,9));
    List<Integer> singleSleeperSeats = new ArrayList<>(Arrays.asList(1,2,3,4));
    List<Integer> doubleSleeperSeats = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));

    // To store entries
    Map<Integer,List<String>> entry = new LinkedHashMap<>();


}
