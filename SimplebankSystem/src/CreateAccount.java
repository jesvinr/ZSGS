public class CreateAccount {
    String name,password;
    int age,amount;
    String phoneNumber,accountNumber;
    CreateAccount(String name, int age, String phoneNUmber,String password,int amount){
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNUmber;
        this.password = password;
        this.amount = amount;
        accountNumber = name+age;
    }
    void printDetails(){
        System.out.println("Account number: "+accountNumber);
        System.out.println("Account Holder name: "+name);
        System.out.println("Password: "+password);
        System.out.println("Age: "+age);
        System.out.println("Amount: "+amount);
        System.out.println("Phone number: "+ phoneNumber);
    }
}
