import java.util.Scanner;

public class MoneyTransfer {
    AllValidationViewModel validate = new AllValidationViewModel();
    AllStorageModel storage = AllStorageModel.getInstance();
    static Scanner sc = new Scanner(System.in);
    void options(){
        System.out.println("Transfer options are...");
        boolean b = true;
        while (b){
            System.out.println("1. Transfer to another account");
            System.out.println("2. Putting money to your account");
            System.out.println("3. Back");
            int choice = sc.nextInt();
            switch (choice){
                case 1:{
                    System.out.println("Enter your account number, your password, To account number"  +
                            " and amount");
                    String fromAcNum,pass,toAcNum;
                    int amount;
                    while(true) {
                        fromAcNum = sc.next();
                        pass = sc.next();
                        toAcNum = sc.next();
                        amount = sc.nextInt();
                        sc.nextLine();

                        if (validate.checkFromAccountIsValid(fromAcNum, pass)
                                && validate.checkAmountIsAvailable(fromAcNum, amount)
                                && validate.checkToAccountIsValid(toAcNum)) {
                            break;
                        }
                        System.out.println("Please enter valid details...");
                    }
                    Exchange(fromAcNum,toAcNum,amount);
                    break;
                }
                case 2:{
                    System.out.println("Enter your account number, your password and and amount: ");
                    String AcNum,pass;
                    int amount;
                    while (true){
                        AcNum = sc.next();
                        pass = sc.next();
                        amount = sc.nextInt();
                        sc.nextLine();
                        if (validate.checkFromAccountIsValid(AcNum, pass)) {
                            break;
                        }
                        System.out.println("Please enter valid details...");
                    }

                    CreateAccount ac = storage.getAccount(AcNum);
                    ac.amount = ac.amount+amount;
                    break;
                }
                case 3: {
                    b=false;
                    break;
                }
            }

        }
    }

    // to from money change
    void Exchange(String fromAcNum,String toAcNum,int money){
        CreateAccount toUser = storage.getAccount(toAcNum);
        CreateAccount fromUser = storage.getAccount(fromAcNum);
        fromUser.amount = fromUser.amount-money;
        toUser.amount = toUser.amount+money;
    }
}
