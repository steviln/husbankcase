/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package husbank.husbankcase.data.entities;

import java.util.ArrayList;

/**
 *
 * @author stevi
 */
public class LoanApplication {
    
    private Integer applicationNumber = null;
    private ArrayList<Borrowers> lanetakere = new ArrayList<Borrowers>();
    private Integer  lanebelop = null;
    private Integer lopetid = null;
    private Integer avdradsfriPeriode = null;
    private String type = null;
    private String behov = null;
    
    public LoanApplication(Integer applicationNumberNew, Integer lb, Integer lt, Integer ap, String typ, String nbehov){
        this.applicationNumber = applicationNumberNew;
        this.lanebelop = lb;
        this.lopetid = lt;
        this.avdradsfriPeriode = ap;
        this.type = typ; 
        this.behov = nbehov;
    }
    
    public ArrayList<Borrowers> getLanetakere(){
        return this.lanetakere;
    }
    
    public void setLanetakere(ArrayList<Borrowers> newValue){
        this.lanetakere = newValue;
    }
    
    public String getType(){
        return this.type;
    }
    
    public void setType(String newValue){
        this.type = newValue;
    }
    
    public String getBehov(){
        return this.behov;
    }
    
    public void setBehov(String newValue){
        this.behov = newValue;
    }
    
    public Integer getLopetid(){
        return this.lopetid;
    }
    
    public void setLoepetid(Integer newValue){
        this.lopetid = newValue;
    }

    public Integer getAvdradsfriPeriode(){
        return this.avdradsfriPeriode;
    }
    
    public void setAvdradsfriPeriode(Integer newValue){
        this.avdradsfriPeriode = newValue;
    }    
    
    public Integer getLanebelop(){
        return this.lanebelop;
    }
    
    public void setLanebelop(Integer newValue){
        this.lanebelop = newValue;
    }
    
    public Integer getApplicationNumber(){
        return this.applicationNumber;
    }
    
    public void setApplicationNumber(Integer newAppNumber){
        this.applicationNumber = newAppNumber;
    }
    
}
