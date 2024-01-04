package create_account;

import java.util.Scanner;

public class CreateAccountView {
    CreateAccountViewModel cvm = new CreateAccountViewModel();
    public void init(){
        Scanner sc= new Scanner(System.in);
        String userName = "";
        int userAge = 0,userAmount =0;
        String userPassword = "";
        String userNumber = "";

        System.out.println("                 Account Details                 ");
        boolean loopFlag = true;

        while(loopFlag) {
            System.out.print("Enter user name: ");
            userName = sc.nextLine();
            if (!cvm.checkName(userName)) {
                System.out.println("please enter valid username... [Name length => 3 to 50]");
                continue;
            }

            System.out.print("Enter user age: ");
            userAge = sc.nextInt();
            sc.nextLine();
            if (!cvm.checkAge(userAge)) {
                System.out.println("Please enter valid age... [Age range => 13 to 100]");
                continue;
            }

            System.out.print("Enter initial amount: ");
            userAmount = sc.nextInt();
            sc.nextLine();
            if (!cvm.checkAmountFirstTime(userAmount)) {
                System.out.println("please enter valid amount... [Amount range => 500 to 5000]");
                continue;
            }

            System.out.print("Enter phone number: ");
            userNumber = sc.nextLine();
            if (!cvm.checkPhoneNumber(userNumber)) {
                System.out.println("Please enter valid phone number...");
                continue;
            }


            System.out.print("Enter password: ");
            userPassword = sc.nextLine();
            if (!cvm.checkPassword(userPassword)) {
                System.out.println("please enter valid password... [password length range => 8 to 20]");
                continue;
            }
            loopFlag = false;
        }
        cvm.putAccountVM(userName,userPassword,userAge,userAmount,userNumber);
        System.out.println("New account created successfully....");
    }
}
