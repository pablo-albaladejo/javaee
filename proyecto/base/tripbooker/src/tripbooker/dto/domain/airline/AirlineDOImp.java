package tripbooker.dto.domain.airline;

import java.util.Objects;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public class AirlineDOImp implements IAirlineDO{
    private int airlineID;
    private String code;
    private String name;
    private int countryID;

    @Override
    public int getAirlineID() {
        return airlineID;
    }

    @Override
    public void setAirlineID(int airlineID) {
        this.airlineID = airlineID;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getCountryID() {
        return countryID;
    }

    @Override
    public void setCountryID(int countryID) {
        this.countryID = countryID;
    }

    @Override
    public String toString() {
        return "("
                + "airlineID " + airlineID
                + ", code: " + code
                + ", name: " + name 
                + ", countryID: " + countryID
                +")";
        
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + this.airlineID;
        hash = 41 * hash + Objects.hashCode(this.code);
        hash = 41 * hash + Objects.hashCode(this.name);
        hash = 41 * hash + this.countryID;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AirlineDOImp other = (AirlineDOImp) obj;
        if (this.airlineID != other.airlineID) {
            return false;
        }
        return true;
    }
    
    
    
}
