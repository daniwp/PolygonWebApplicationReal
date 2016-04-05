/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentationLayer.servlet;

import exceptions.UserAlreadyExistsException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import serviceLayer.Controller;

/**
 *
 * @author PeterHenriksen
 */
@WebServlet(name = "AddCustomer", urlPatterns = {"/addcustomer"})
public class AddCustomer extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        RequestDispatcher rd = null;
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(30 * 60);
        
        try {

            Controller controller = new Controller();

            String companyName = request.getParameter("companyName");
            String customerFirstName = request.getParameter("companyOwnerFirstName");
            String customerLastName = request.getParameter("companyOwnerLastName");
            String customerUsername = request.getParameter("customerUsername");
            String customerPassword = request.getParameter("customerPassword");
            String customerEmail = request.getParameter("customerEmail");

            controller.addCustomer(companyName, customerFirstName, customerLastName, customerUsername, customerPassword, customerEmail);

            rd = request.getRequestDispatcher("index.jsp");
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
            rd = request.getRequestDispatcher("createCustomer.jsp");
        } catch (UserAlreadyExistsException ex) {
            session.setAttribute("userExistsError", ex.getMessage());
            rd = request.getRequestDispatcher("createCustomer.jsp");
        }
        rd.forward(request, response);
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AddCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AddCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
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
