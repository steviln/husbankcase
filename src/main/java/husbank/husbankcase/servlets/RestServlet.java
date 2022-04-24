/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package husbank.husbankcase.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.util.stream.Collectors;

import com.google.gson.Gson; 

import husbank.husbankcase.data.DataStore;
import husbank.husbankcase.data.entities.LoanApplication;
import husbank.husbankcase.data.response.CreateApplicationResponse;

/**
 *
 * @author stevi
 */
public class RestServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        
        Integer newID = 0;
        String status = "Ukjent";
        
        ServletContext context = getServletContext();
        Gson jsonReader = new Gson();
        
        try{                    

            String jsonbody = request.getReader().lines().collect(Collectors.joining());      

            DataStore dataStore = (DataStore)context.getAttribute("datastore");
                 
            LoanApplication newApp = jsonReader.fromJson(jsonbody, LoanApplication.class);     
            dataStore.addApplication(newApp);
            newID = newApp.getApplicationNumber(); 
            status = "Mottatt";
            System.out.println("Added application:");
            System.out.println(jsonReader.toJson(newApp));

        }catch(Exception e){
            System.out.println(e.toString());
        }
        
        CreateApplicationResponse resp = new CreateApplicationResponse(newID, status);
        String jsonResp = jsonReader.toJson(resp);
        
        
        
        try ( PrintWriter out = response.getWriter()) {
            out.print(jsonResp);
        }
    }
    
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
