package presentationLayer.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import serviceLayer.ControllerFacade;

/**
 *
 * @author Daniel
 */
@WebServlet(name = "EditBuilding", urlPatterns = {"/editbuilding"})
public class EditBuilding extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = null;
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(30 * 60);

        ControllerFacade controllerFacade = new ControllerFacade();

        try {

            String buildingName = request.getParameter("buildingName");
            String ownerName = request.getParameter("ownerName");
            String address = request.getParameter("buildingAddress");
            String city = request.getParameter("buildingCity");
            int zipcode = Integer.parseInt(request.getParameter("buildingZipcode"));
            int buildingYear = Integer.parseInt(request.getParameter("buildingYear"));
            int numberOfFloors = Integer.parseInt(request.getParameter("nrOfFloors"));
            double totalM2 = Double.parseDouble(request.getParameter("totalM2"));
            int buildingCondition = Integer.parseInt(request.getParameter("conditionLevel"));
            int buildingId = Integer.parseInt(request.getParameter("buildingId"));

            controllerFacade.editBuildingByBuildingId(buildingId, buildingName, address, zipcode, city, buildingYear, numberOfFloors, totalM2, ownerName, buildingCondition);
            
            session.setAttribute("saveComplete", "Your changes has been saved successfully");
            
            rd = request.getRequestDispatcher("viewSingleBuilding.jsp");

        } catch (Exception e) {
            e.printStackTrace();
            rd = request.getRequestDispatcher("editBuilding.jsp");
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
