package tripbooker.dto.bean.airport;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public class AirportBean implements IAirportBean{
    private String code;
    private String name;
    private String cityCode;
    private String cityName;

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
    public String getCityCode() {
        return cityCode;
    }

    @Override
    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    @Override
    public String getCityName() {
        return cityName;
    }

    @Override
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public String toString() {
        return "AirportBean{" + "code=" + code + ", name=" + name + ", cityCode=" + cityCode + ", cityName=" + cityName + '}';
    }

}
