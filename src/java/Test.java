
import dataAccessLayer.mapper.FileMapper;
import java.sql.SQLException;
import java.util.List;
import serviceLayer.ControllerFacade;
import serviceLayer.entity.Customer;
import serviceLayer.entity.Report;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Nicolai
 */
public class Test {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        ControllerFacade cF = new ControllerFacade();
        FileMapper fM = new FileMapper();
        List<Report> reports = cF.getAllReportsByBuildingId(1);
        
        
        for (Report report : reports) {
            System.out.println(report.getFileName());
            report.getBuildingId();
        }
    }
}
