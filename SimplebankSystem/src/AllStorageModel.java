import java.util.*;

class AllStorageModel {
    private static AllStorageModel st;
    // Storage
    AllStorageModel(){
        // Empty Constructor
    }
    public static AllStorageModel getInstance() {
        if (st == null) {
            st = new AllStorageModel();
        }
        return st;
    }
    List<CreateAccount> accountList = new ArrayList<>();
    Map<String,String> accountNumAndPass= new LinkedHashMap<>();
    CreateAccount getAccount(String acNum){
        int size = accountList.size();
        for(int i=0;i<size;i++){
            if(accountList.get(i).accountNumber.equals(acNum)){
                return accountList.get(i);
            }
        }
        System.out.println("No accounts found");
        return null;
    }
}
