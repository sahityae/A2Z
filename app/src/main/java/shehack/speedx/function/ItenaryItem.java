package shehack.speedx.function;

/**
 * Created by Sahitya on 5/13/2017.
 */

public class ItenaryItem {
    private String driverName;
    private String agency;
    private String address;
    private String contact;



    private String tag;

    public ItenaryItem(String tag,String driverName, String agency, String address, String contact) {
        this.driverName = driverName;
        this.agency = agency;
        this.address = address;
        this.contact = contact;
        this.tag=tag;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
