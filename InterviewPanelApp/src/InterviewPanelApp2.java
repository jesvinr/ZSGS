import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class InterviewPanelApp2 {
    static List<Candidates> CompleteCandDetails = new ArrayList<>();
    static Queue<Candidates> candidatesQueue = new LinkedList<>();
    public static void main(String[] args) {
        InterviewPanelApp iPa = new InterviewPanelApp();
        CandidatesList();
        Scanner scan = new Scanner(System.in);
        int choice;
        do{
            System.out.println("\nEnter the input");
            System.out.println("""
                    1.Add Candidates Details\s
                    2.Print Waiting Students\s
                    3.Interview Completed Candidates\s
                    0.exit""");
            choice = scan.nextInt();
            scan.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("\nEnter the Candidate name and IdNumber:  ");
                    String name = scan.next();
                    int age = scan.nextInt();
                    scan.nextLine();
                    Candidates cd = new Candidates(name, age);
                    candidatesQueue.add(cd);
                    break;
                case 2:
                    System.out.println("Candidates waiting list:\n" + candidatesQueue);
                    break;
                case 3:
                    InterviewCompleted();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }
        }while (choice !=0);
    }

    private static void InterviewCompleted() {
        System.out.println("\nInterview completed for:");
        for (Candidates  li: CompleteCandDetails) {
            System.out.println(li);
        }
    }

    private static void CandidatesList() {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        scheduler.scheduleAtFixedRate(() -> {
            if (!candidatesQueue.isEmpty()) {
                Candidates c = candidatesQueue.poll();
                CompleteCandDetails.add(c);
                System.out.println("Interview Completed for " + c);
            }
        }, 0, 15, TimeUnit.SECONDS);
    }

}

class Candidates {
    private final String name;
    private final int IdNumber;

    Candidates(String name, int id) {
        this.name = name;
        this.IdNumber = id;
    }

    public String toString() {
        return "Candidate (name = " + name + "  age = " + IdNumber + ")";
    }
}
