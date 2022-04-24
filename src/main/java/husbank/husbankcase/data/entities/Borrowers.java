/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package husbank.husbankcase.data.entities;

/**
 *
 * @author stevi
 */
public class Borrowers {
    
    private String fnr = null;
    private String navn = null;
    
    public Borrowers(String nfnr, String nnavn){
        this.fnr = nfnr;
        this.navn = nnavn;
    }
    
    public String getFnr(){
        return this.fnr;
    }
    
    public void setFnr(String nfnr){
        this.fnr = nfnr;
    }
    
    public String getNavn(){
        return this.navn;
    }
    
    public void setnavn(String nnavn){
        this.navn = nnavn;
    }
    
}
