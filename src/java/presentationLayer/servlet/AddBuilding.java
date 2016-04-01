package presentationLayer.servlet;

import serviceLayer.Controller;
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

@WebServlet(name = "AddBuilding", urlPatterns = {"/addbuilding"})
public class AddBuilding extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        RequestDispatcher rd = null;
        try {

        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(30 * 60);

            Controller controller = new Controller();

            String buildingName = request.getParameter("buildingName");
            String ownerName = request.getParameter("ownerName");
            String buildingAddress = request.getParameter("buildingAddress");
            String buildingCity = request.getParameter("buildingCity");
            int buildingZipcode = Integer.parseInt(request.getParameter("buildingZipcode"));
            int buildingYear = Integer.parseInt(request.getParameter("buildingYear"));
            int nrOfFloors = Integer.parseInt(request.getParameter("nrOfFloors"));
            double totalM2 = Double.parseDouble(request.getParameter("totalM2"));
            int conditionLevel = Integer.parseInt(request.getParameter("conditionLevel"));
            
            controller.addBuilding(buildingName, buildingAddress, buildingZipcode, buildingCity, buildingYear, nrOfFloors, totalM2, ownerName, conditionLevel, 1);
            
            rd = request.getRequestDispatcher("addFloor.jsp");
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
            rd = request.getRequestDispatcher("addBuilding.jsp");
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
