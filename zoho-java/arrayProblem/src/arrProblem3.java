import java.util.Scanner;

public class arrProblem3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the String(odd length only): ");
        String string = sc.nextLine();
        printPattern(string);
    }

    private static void printPattern(String str) {
        int len = str.length();
        for(int i=0; i<len; i++) {
            for(int j=0; j<len; j++) {
                if(i==j) {
                    System.out.print(str.charAt(i)+" ");
                }
                else if(len-1-i==j && i!=j) {
                    System.out.print(str.charAt(i)+" ");
                }
                else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}
