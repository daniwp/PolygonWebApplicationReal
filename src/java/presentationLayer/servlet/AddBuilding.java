package presentationLayer.servlet;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import serviceLayer.ControllerFacade;
import serviceLayer.entity.Customer;

@WebServlet(name = "AddBuilding", urlPatterns = {"/addbuilding"})
public class AddBuilding extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        RequestDispatcher rd = null;
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(30 * 60);
        
        ControllerFacade controllerFacade = new ControllerFacade();
        
        try {

            session.setAttribute("nrOfFloors", request.getParameter("nrOfFloors"));
            session.setAttribute("buildingName", request.getParameter("buildingName"));

            int customerId = Integer.parseInt(request.getParameter("customerId"));

            String buildingName = request.getParameter("buildingName");
            String ownerName = request.getParameter("ownerName");
            String buildingAddress = request.getParameter("buildingAddress");
            String buildingCity = request.getParameter("buildingCity");
            int buildingZipcode = Integer.parseInt(request.getParameter("buildingZipcode"));
            int buildingYear = Integer.parseInt(request.getParameter("buildingYear"));
            int nrOfFloors = Integer.parseInt(request.getParameter("nrOfFloors"));
            double totalM2 = Double.parseDouble(request.getParameter("totalM2"));
            int conditionLevel = Integer.parseInt(request.getParameter("conditionLevel"));

            controllerFacade.addBuilding(buildingName, buildingAddress, buildingZipcode, buildingCity, buildingYear, nrOfFloors, totalM2, ownerName, conditionLevel, customerId);

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
