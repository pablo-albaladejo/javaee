package tripbooker.dto.domain.city;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public class CityDOImp implements ICityDO{
    private int cityID;
    private String code;
    private String name;
    private int countryID;

    @Override
    public int getCityID() {
        return cityID;
    }

    @Override
    public void setCityID(int cityID) {
        this.cityID = cityID;
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
        return "CityDOImp{" + "cityID=" + cityID + ", code=" + code + ", name=" + name + ", countryID=" + countryID + '}';
    }
}
