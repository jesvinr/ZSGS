import java.util.Arrays;
import java.util.Scanner;

public class arrProblem5 {
    // printing number as odd and even back to back...
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the No of Elements");
        int len = sc.nextInt();
        int[] numbers = new int[len];

        
        System.out.print("Enter the Array Elements: ");
        for(int i=0; i<len; i++) {
            numbers[i] = sc.nextInt();
        }

        Arrays.sort(numbers);
        oddFrontEvenReverseSort(numbers);
        System.out.println(Arrays.toString(numbers));
    }

    private static void oddFrontEvenReverseSort(int[] numbers) {
        int len = numbers.length-1;
        if(len%2 != 0)
            len--;

        for(int i=len; i>0; i-=2) {
            int currentSmall = numbers[0];
            for(int j=1; j<=i; j++) {
                numbers[j-1] = numbers[j];
            }
            numbers[i] = currentSmall;
        }
    }

}
