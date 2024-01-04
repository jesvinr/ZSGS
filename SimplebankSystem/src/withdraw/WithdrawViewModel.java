package withdraw;
import repository.AllStorageModel;
public class WithdrawViewModel {
    AllStorageModel storage = AllStorageModel.getInstance();
    boolean checkFromAccountIsValid(String accountNumber, String password){
        if(storage.checkAccountAndPassword(accountNumber,password)){
            return true;
        }
        return false;
    }

    boolean checkAmountIsAvailable(String accountNum,int amount){
        return storage.checkAmount(accountNum,amount);
    }
}
