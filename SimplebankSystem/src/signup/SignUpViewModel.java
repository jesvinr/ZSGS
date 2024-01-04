package signup;

import repository.AccountDto;
import repository.StorageModel;

public class SignUpViewModel {
    private StorageModel storage = StorageModel.getInstance();
    private AccountDto account = new AccountDto();
    boolean checkFromAccountIsValid(String accountNumber, String password){

        if(storage.checkAccountAndPassword(accountNumber,password)){
            account = storage.getAccount(accountNumber);
            return true;
        }
        return false;
    }

    public String getNameVm(){
        return account.getName();
    }
    public int getAgeVm(){
        return account.getAge();
    }
    public String getPhoneNumberVm(){return account.getPhoneNumber();}
    public int getAmountVm(){return account.getAmount();}
    public String getAccountNumberVm(){return account.getAccountNumber();}
}
