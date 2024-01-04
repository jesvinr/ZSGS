import create_account.CreateAccountView;
import money_transfer.MoneyTransferView;
import repository.AllStorageModel;
import withdraw.WithdrawView;

import java.util.InputMismatchException;
import java.util.Scanner;


// UI and print statement
public class DashboardView {
    static AllStorageModel storage;
    public void init() {
        Scanner sc= new Scanner(System.in);
        storage = AllStorageModel.getInstance();
        boolean boardLoop = true;  // dashboard flag

        while(boardLoop){
            System.out.println("Enter options:  ");
            System.out.println("1. Create account");
            System.out.println("2. Sign in");
            System.out.println("3. Withdraw" );
            System.out.println("4. Money transfer");
            System.out.println("5. Exit");
            int choice=-1;
            try{
                choice = sc.nextInt();
                sc.nextLine();
            }
            catch (InputMismatchException e){
                sc.nextLine();
            }

            switch (choice){
                case 1:{
                    CreateAccountView createAccount = new CreateAccountView();
                    createAccount.init();
                    break;
                }
                case 2:{
                    // not completed yet.
                    break;
                }
                case 3:{
                    WithdrawView withdraw = new WithdrawView();
                    withdraw.init();
                    break;
                }
                case 4:{
                    MoneyTransferView moneyTransfer = new MoneyTransferView();
                    moneyTransfer.init();
                    break;
                }
                case 5:{
                    System.out.println("Thank you for using our application...");
                    boardLoop = false;
                    break;
                }
                default:{
                    System.out.println("Please enter valid choice... ");
                }
            }
        }
    }
}