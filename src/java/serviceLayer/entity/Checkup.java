package serviceLayer.entity;

/**
 *
 * @author danie
 */
public class Checkup {
    private int checkupId;
    private String status;
    private int buildingId;
    private String customerEmail;

    public Checkup(int checkupId, String status, String customerEmail, int buildingId) {
        this.checkupId = checkupId;
        this.status = status;
        this.buildingId = buildingId;
        this.customerEmail = customerEmail;
    }

    public Checkup(String status, String customerEmail, int buildingId) {
        this.status = status;
        this.buildingId = buildingId;
        this.customerEmail = customerEmail;
    }

    public Checkup() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public int getCheckupId() {
        return checkupId;
    }

    public void setCheckupId(int checkupId) {
        this.checkupId = checkupId;
    }

    public int getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(int buildingId) {
        this.buildingId = buildingId;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }
}
