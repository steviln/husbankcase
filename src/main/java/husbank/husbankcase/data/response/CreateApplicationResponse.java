/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package husbank.husbankcase.data.response;

/**
 *
 * @author stevi
 */
public class CreateApplicationResponse {
    
    private Integer applicationID = null;
    private String status = null;
    
    public CreateApplicationResponse(Integer appID, String nstatus){
        this.applicationID = appID;
        this.status = nstatus;
    }
    
    public Integer getApplicationID(){
        return this.applicationID;
    }
    
    public String getStatus(){
        return this.status;
    }
    
    public void setApplicationID(Integer newValue){
        this.applicationID = newValue;
    }
    
    public void setStatus(String newValue){
        this.status = newValue;
    }
}
