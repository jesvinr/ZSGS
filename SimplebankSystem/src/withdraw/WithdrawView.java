package withdraw;

import java.util.Scanner;

public class WithdrawView {
    WithdrawViewModel wvm = new WithdrawViewModel();
    public void init(){
        Scanner sc = new Scanner(System.in);
        String acNum = "";
        String pass = "";
        int amount = 0;

        boolean withdrawLoop = true;

        while (withdrawLoop) {
            System.out.print("Enter account number: ");
            acNum = sc.next();
            System.out.print("Enter password: ");
            pass = sc.next();

            if(!wvm.checkFromAccountIsValid(acNum,pass)){
                System.out.println("Please enter correct username and password...");
                continue;
            }

            System.out.println("Enter amount need to be withdrawn: ");
            amount = sc.nextInt();

            if(!wvm.checkAmountIsAvailable(acNum,amount)){
                System.out.println("Amount not available..");
                continue;
            }

            withdrawLoop = false;
        }
    }
}
