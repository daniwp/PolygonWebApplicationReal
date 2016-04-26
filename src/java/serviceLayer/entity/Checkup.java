package serviceLayer.entity;

/**
 *
 * @author danie
 */
public class Checkup {
    private int checkupId;
    private String status, date, customerEmail;
    private int buildingId;

    public Checkup(int checkupId, String status, String date, String customerEmail, int buildingId) {
        this.checkupId = checkupId;
        this.status = status;
        this.date = date;
        this.customerEmail = customerEmail;
        this.buildingId = buildingId;
    }

    public Checkup(String status, String date, String customerEmail, int buildingId) {
        this.status = status;
        this.date = date;
        this.customerEmail = customerEmail;
        this.buildingId = buildingId;
    }

    public Checkup() {
    }

    public String getDate() {
        return date;
    }

    public String getStatus() {
        return status;
    }

    public int getCheckupId() {
        return checkupId;
    }

    public int getBuildingId() {
        return buildingId;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }
}
