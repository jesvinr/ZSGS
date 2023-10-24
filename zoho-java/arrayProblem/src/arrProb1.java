import java.util.Scanner;

public class arrProb1 {
    /** Finding grand children of celebrity **/
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        // input values in form of [child, father]
        /*
        luke shaw
        wayne rooney
        rooney ronaldo
        shaw rooney
        String[][] family = new String[4][2];
        family[0] = new String[]{"luke", "shaw"};
        family[1] = new String[]{"wayne","rooney"};
        family[2] = new String[]{"rooney","ronaldo"};
        family[3] = new String[]{"shaw","rooney"};
         **/
        //Getting data
        System.out.println("Enter family tree count: ");
        int famCount = Integer.parseInt(scan.nextLine());
        System.out.println("Enter the family tree: ");
        String[][] family = new String[famCount][2];
        for(int i=0;i<famCount;++i){
            String relation = scan.nextLine();
            System.out.println("saved");
            family[i] = relation.split(" ");
        }

        // getting user input [celebrity]
        System.out.println("Enter the Celebrity name to find grand children: ");
        String celebrityName = scan.nextLine();

        // Variable for storing father name and counting grand children
        int countGC = 0;
        String fathername = "";
        // finding grand children
        for (int i=0;i<family.length;i++){
            if(family[i][1].equals(celebrityName)) {
                fathername = family[i][0];
                break;
            }
        }

        //Counting grandchilder
        for(int i1=0;i1<family.length;i1++){
            if(family[i1][1].equals(fathername)) countGC++;
        }

        //Printing grandChildren count
        System.out.println(countGC);
    }
}
