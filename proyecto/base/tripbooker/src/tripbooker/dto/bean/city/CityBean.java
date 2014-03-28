package tripbooker.dto.bean.city;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public class CityBean implements ICityBean{
    String name;
    String code;
    String countryCode;
    String countryName;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
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
    public String getCountryCode() {
        return countryCode;
    }

    @Override
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @Override
    public String getCountryName() {
        return countryName;
    }

    @Override
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @Override
    public String toString() {
        return "CityBean{" + "name=" + name + ", code=" + code + ", countryCode=" + countryCode + ", countryName=" + countryName + '}';
    }

}
