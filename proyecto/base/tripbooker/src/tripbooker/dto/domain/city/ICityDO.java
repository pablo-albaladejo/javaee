package tripbooker.dto.domain.city;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public interface ICityDO {
    int getCityID();
    void setCityID(int cityID);

    String getCode();
    void setCode(String code);

    String getName();
    void setName(String name);
    
    int getCountryID();
    void setCountryID(int countryID);
}
