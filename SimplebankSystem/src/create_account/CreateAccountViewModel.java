package create_account;

import repository.StorageModel;
import repository.AccountDto;

public class CreateAccountViewModel {
    StorageModel storage = StorageModel.getInstance();

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
        if(amount>=500 && amount<=5000){
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
    public void putAccountVM(String name,String pass,int age,int amount, String phoneNumber) {
        AccountDto createDto = new AccountDto();
        createDto.setName(name);
        createDto.setPassword(pass);
        createDto.setAge(age);
        createDto.setAmount(amount);
        createDto.setPhoneNumber(phoneNumber);
        createDto.setAccountNumber(createDto.getName()+createDto.getAge());
        storage.putAccount(createDto);
    }
}
