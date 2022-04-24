/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package husbank.husbankcase.data;

import husbank.husbankcase.data.entities.LoanApplication;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 *
 * @author stevi
 */
public class DataStore {
    
   HashMap<String,LoanApplication> loanApplications = null;
   private AtomicInteger currentIDnumber = new AtomicInteger(0);
    
    public DataStore(Integer setCurrentNumber){
        this.currentIDnumber = new AtomicInteger(setCurrentNumber);
        loanApplications = new HashMap<String,LoanApplication>();
    }
    
    public void addApplication(LoanApplication newApplication){
        Integer newIdNumber = currentIDnumber.getAndIncrement();
        newApplication.setApplicationNumber(newIdNumber);
        loanApplications.put(newIdNumber.toString(), newApplication);
    }
    
    public List getLoanApplications(){
        return this.loanApplications.values().stream().collect(Collectors.toList());
    }
    
    public Integer getCurrentIDnumber(){
        return this.currentIDnumber.get();
    }
    
}
