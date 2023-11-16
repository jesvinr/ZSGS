import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;
import java.util.Timer;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class TourApp {
    public static void main(String[] args) throws IOException, org.json.simple.parser.ParseException, InterruptedException {
        System.out.println("===================================== Romeo Tour App ========================================");

        System.out.println("                           Hello World, Welcome to Romeo Tour App...");
        TourApp obj = new TourApp();
        obj.destination();

    }

    private void destination() throws IOException, org.json.simple.parser.ParseException, InterruptedException {
        Stack<Map> travelDetails = new Stack<>();
        Scanner sc = new Scanner(System.in);
        JSONParser parser = new JSONParser();
        JSONObject jsonObj = (JSONObject) parser.parse(new FileReader(
                "D:\\java-2022-06\\workplace_1\\zoho_session\\TourApp\\src\\TravelSite.json"));

        travelDetails.push((Map) ((Map) jsonObj).get("destination"));
        while (true) {
            System.out.println("\nEnter the Number:");
            destinationList(travelDetails.peek());
            System.out.println("0:Exit");
            System.out.println("-1:go Back");

            int input = sc.nextInt();
            if (input == -1) {
                if (travelDetails.size() > 1) {
                    travelDetails.pop();
                }
            } else if (input == 0) {
                System.out.println("Its a pleasure working with you...");
                System.exit(0);
            } else {
                if (input <= travelDetails.peek().size()) {
                    travelDetails.push((Map<String, String>) ((Map) jsonObj).get(travelDetails.peek().get(input + "")));
                } else {
                    System.out.println("Enter a Number");
                }
            }
        }
    }

    private void destinationList(Object values) {

        Map<String, Object> details = (Map) values;

        if (details != null) {
            for (Map.Entry<String, Object> map : details.entrySet()) {
                System.out.println(map.getKey() + ":" + map.getValue());
            }
        } else
            System.out.println("Wrong Input...");

    }
}
