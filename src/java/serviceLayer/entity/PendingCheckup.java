package serviceLayer.entity;

/**
 *
 * @author Daniel
 */
public class PendingCheckup {

    private Checkup checkup;
    private String companyName;
    private String buildingName;
    private int buildingId;

    public PendingCheckup(Checkup checkup, String companyName, String buildingName, int buildingId) {
        this.checkup = checkup;
        this.companyName = companyName;
        this.buildingName = buildingName;
        this.buildingId = buildingId;
    }

    public int getBuildingId() {
        return buildingId;
    }

    public Checkup getCheckup() {
        return checkup;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getBuildingName() {
        return buildingName;
    }
}
