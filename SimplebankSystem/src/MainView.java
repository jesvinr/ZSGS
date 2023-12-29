import java.util.Scanner;
// UI and print statement
public class MainView {
    static AllStorageModel storage;
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        storage = AllStorageModel.getInstance();
        while(true){
            System.out.println("Enter options:  ");
            System.out.println("1. Create account");
            System.out.println("2. Sign in");
            System.out.println("3. Withdraw" );
            System.out.println("4. Money transfer");
            System.out.println("5. Exit");
            int choice;
            while(true) {
                choice = Integer.parseInt(sc.nextLine());
                if(choice>0 && choice<=5){
                    break;
                }
                System.out.println("Please enter valid option....");
            }
            AllValidationViewModel validate = new AllValidationViewModel();

            switch (choice){
                case 1:{
                    System.out.println("Please enter name, age, amount, password, phone number: ");
                    String name,password,phoneNumber;
                    int age,amount;

                    while (true){
                        name = sc.next();
                        age = sc.nextInt();
                        amount = sc.nextInt();
                        password = sc.next();
                        phoneNumber = sc.next();
                        sc.nextLine();
                        if(validate.checkAge(age) && validate.checkName(name) &&
                                validate.checkPassword(password) && validate.checkPhoneNumber(phoneNumber)
                        && validate.checkAmountFirstTime(amount))
                        {
                            break;
                        }
                        System.out.println("Please enter proper name, age, amount, password, phone number: ");
                    }
                    CreateAccount createAccount = new CreateAccount(name,age,phoneNumber,password,amount);
                    storage.accountList.add(createAccount);
                    storage.accountNumAndPass.put(createAccount.accountNumber,password);
                    System.out.println(storage.accountNumAndPass.containsKey(createAccount.accountNumber));
                    createAccount.printDetails();
                    break;
                }
                case 2:{
                    System.out.println("Please enter account number and password");
                    String acNum;
                    String pass;
                    while (true) {
                        acNum = sc.next();
                        pass = sc.next();
                        sc.nextLine();
                        if(validate.checkFromAccountIsValid(acNum,pass)){
                            break;
                        }
                        System.out.println("Please enter valid details...");
                    }
                    CreateAccount ca  = storage.getAccount(acNum);
                    ca.printDetails();
                    break;
                }
                case 3:{
                    System.out.println("Enter Account number and password, money needed to be withdrawn: ");
                    String acNum;
                    String pass;
                    int money;
                    while (true) {
                        acNum = sc.next();
                        pass = sc.next();
                        money = sc.nextInt();
                        sc.nextLine();
                        if(validate.checkFromAccountIsValid(acNum,pass)){
                            break;
                        }
                        System.out.println("Please enter valid details...");
                    }
                    new Withdraw().AmountWithdraw(acNum,money);
                    System.out.println("Amount of "+money+" is successfully withdrawn...");
                    break;
                }
                case 4:{
                    MoneyTransfer moneyTransfer = new MoneyTransfer();
                    //System.out.println("Enter from account, to account, ");
                    moneyTransfer.options();
                    break;
                }
                case 5:{
                    System.out.println("Thank you for using our application...");
                    System.exit(0);
                    break;
                }
            }
        }
    }
}