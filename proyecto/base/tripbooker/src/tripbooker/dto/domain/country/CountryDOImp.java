package tripbooker.dto.domain.country;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public class CountryDOImp implements ICountryDO{
    private int countryID;
    private String code;
    private String name;

    @Override
    public int getCountryID() {
        return countryID;
    }

    @Override
    public void setCountryID(int countryID) {
        this.countryID = countryID;
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
    public String toString() {
        return "CountryDOImo{" + "countryID=" + countryID + ", code=" + code + ", name=" + name + '}';
    }
}
