public class AllValidationViewModel {
    // create Account validation
    boolean checkName(String name){
        if(name.length()>=3 && name.length()<50){
            return true;
        }
        return false;
    }
    boolean checkAge(int age){
        if(age>13 && age<120){
            return true;
        }
        return false;
    }
    boolean checkAmountFirstTime(int amount){
        if(amount>=2000 && amount<=10000){
            return true;
        }
        return false;
    }
    boolean checkPhoneNumber(String phoneNumber){
        if(phoneNumber.length()==10){
            return true;
        }
        return false;
    }
    boolean checkPassword(String password){
        if(password.length()>=8){
            return true;
        }
        return false;
    }

    // for money transfer validation
    AllStorageModel storage = AllStorageModel.getInstance();
    boolean checkFromAccountIsValid(String accountNumber, String password){

        System.out.println(storage.accountNumAndPass.containsKey(accountNumber));
        if(storage.accountNumAndPass.containsKey(accountNumber) &&
            storage.accountNumAndPass.get(accountNumber).equals(password)){
            return true;
        }
        return false;
    }

    boolean checkAmountIsAvailable(String accountNum,int amount){
        int i;
        for(i=0;i<storage.accountList.size();i++){
            String tempAcNum = storage.accountList.get(i).accountNumber;
            int tempAcAmount = storage.accountList.get(i).amount;
            if(tempAcNum.equals(accountNum) && tempAcAmount>amount){
                return true;
            }
        }
        return false;
    }

    boolean checkToAccountIsValid(String toAcNum){
        if(storage.accountNumAndPass.containsKey(toAcNum)){
            return true;
        }
        return false;
    }
}
