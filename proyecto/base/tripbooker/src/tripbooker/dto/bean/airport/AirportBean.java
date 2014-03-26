package tripbooker.dto.bean.airport;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public class AirportBean implements IAirportBean{
    private String code;
    private String name;
    private String city;

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
    public String getCity() {
        return city;
    }

    @Override
    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "AirportBean{" + "code=" + code + ", name=" + name + ", city=" + city + '}';
    }
}
