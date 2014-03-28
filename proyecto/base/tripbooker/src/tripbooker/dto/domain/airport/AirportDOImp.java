package tripbooker.dto.domain.airport;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public class AirportDOImp implements IAirportDO{
    
    private int airportID;
    private String code;
    private String name;
    private int cityID;

    @Override
    public int getAirportID() {
        return airportID;
    }

    @Override
    public void setAirportID(int airportID) {
        this.airportID = airportID;
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
    public int getCityID() {
        return cityID;
    }

    @Override
    public void setCityID(int cityID) {
        this.cityID = cityID;
    }

    @Override
    public String toString() {
        return "AirportDOImp{" + "airportID=" + airportID + ", code=" + code + ", name=" + name + ", cityID=" + cityID + '}';
    }
}
