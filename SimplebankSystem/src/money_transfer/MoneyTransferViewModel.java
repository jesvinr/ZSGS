package money_transfer;

import repository.StorageModel;
import repository.AccountDto;

public class MoneyTransferViewModel {
    private StorageModel storage = StorageModel.getInstance();
    boolean checkFromAccountIsValid(String accountNumber, String password){

        if(storage.checkAccountAndPassword(accountNumber,password)){
            return true;
        }
        return false;
    }

    boolean checkAmountIsAvailable(String accountNum,int amount){
        return storage.checkAmount(accountNum,amount);
    }

    boolean checkToAccountIsValid(String toAcNum){
        return storage.checkAccount(toAcNum);
    }

    // to from money change
    void Exchange(String fromAcNum,String toAcNum,int money){
        //AccountDto accountFrom = storage.
        AccountDto toUser = storage.getAccount(toAcNum);
        AccountDto fromUser = storage.getAccount(fromAcNum);
        fromUser.setAmount(fromUser.getAmount()-money);
        toUser.setAmount(toUser.getAmount()+money);
    }

    public void putMoney(String acNum, int amount) {
        AccountDto user = storage.getAccount(acNum);
        user.setAmount(user.getAmount()+amount);
    }
}
