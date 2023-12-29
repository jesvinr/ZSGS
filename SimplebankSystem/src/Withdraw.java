public class Withdraw {
    void AmountWithdraw(String AcNum, int money){
        AllStorageModel storage = AllStorageModel.getInstance();
        AllValidationViewModel validation = new AllValidationViewModel();
        CreateAccount ca = storage.getAccount(AcNum);
        ca.amount = ca.amount-money;
    }
}
