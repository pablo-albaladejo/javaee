package tripbooker.dto.domain.aircraft;

import java.util.Date;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public class AircraftDOImp implements IAircraftDO{
    
    private int airfarctID;
    private String manufacter;
    private String model;
    private Date date;
    private int business;
    private int tourist;

    @Override
    public int getAirfarctID() {
        return airfarctID;
    }

    @Override
    public void setAirfarctID(int airfarctID) {
        this.airfarctID = airfarctID;
    }

    @Override
    public String getManufacter() {
        return manufacter;
    }

    @Override
    public void setManufacter(String manufacter) {
        this.manufacter = manufacter;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public Date getDate() {
        return date;
    }

    @Override
    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public int getBusiness() {
        return business;
    }

    @Override
    public void setBusiness(int business) {
        this.business = business;
    }

    @Override
    public int getTourist() {
        return tourist;
    }

    @Override
    public void setTourist(int tourist) {
        this.tourist = tourist;
    }

    @Override
    public String toString() {
                return "("
                + "airfarctID " + airfarctID
                + ", manufacter: " + manufacter
                + ", model: " + model
                + ", date: " + date 
                + ", business: " + business
                + ", tourist: " + tourist
                +")";
    }

}

