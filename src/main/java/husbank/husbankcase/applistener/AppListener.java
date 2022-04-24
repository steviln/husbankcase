/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package husbank.husbankcase.applistener;

import jakarta.servlet.ServletContextListener;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.*;
import husbank.husbankcase.data.DataStore;

/**
 *
 * @author stevi
 */
public class AppListener implements ServletContextListener{
    
  @Override
  public void contextDestroyed(ServletContextEvent event) {

  }

  @Override
  public void contextInitialized(ServletContextEvent event) {
      ServletContext context = event.getServletContext();
      DataStore dataStore = (DataStore) context.getAttribute("datastore");
      if(dataStore == null){
          //Here, it should be a check whether the startnumber is a parameter or not, but will not in this instance. 
          Integer initApplicationNumber = Integer.parseInt(context.getInitParameter("startnumber"));
          dataStore = new DataStore(initApplicationNumber);
          context.setAttribute("datastore",dataStore);
      }     
  }  
}
