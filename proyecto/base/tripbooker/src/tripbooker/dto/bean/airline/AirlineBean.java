package tripbooker.dto.bean.airline;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public class AirlineBean implements IAirlineBean{
    private String code;
    private String name;
    private String countryCode;

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
    public String getCountryCode() {
        return countryCode;
    }

    @Override
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @Override
    public String toString() {
        return "AirlineBean{" + "code=" + code + ", name=" + name + ", countryCode=" + countryCode + '}';
    }
}
