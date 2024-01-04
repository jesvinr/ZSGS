package create_account;

import repository.AllStorageModel;
import repository.AccountDto;

public class CreateAccountViewModel {
    AllStorageModel storage = AllStorageModel.getInstance();

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

//    void sendName(String name){
//        createDto.setName(name);
//    }
//
//    void sendPassword(String pass){
//        createDto.setPassword(pass);
//    }
//    void sendAge(int age){
//        createDto.setAge(age);
//    }
//    void sendAmount(int amount){
//        createDto.setAmount(amount);
//    }
//    void sendPhoneNumber(String number){
//        createDto.setPhoneNumber(number);
//    }

    //void store(){storage.}

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

//    void printDetails(){
//        System.out.println("Account number: "+accountNumber);
//        System.out.println("Account Holder name: "+name);
//        System.out.println("Password: "+password);
//        System.out.println("Age: "+age);
//        System.out.println("Amount: "+amount);
//        System.out.println("Phone number: "+ phoneNumber);
//    }



}
