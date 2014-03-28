package tripbooker.dto.domain.country;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public interface ICountryDO {
    int getCountryID();
    void setCountryID(int countryID);

    String getCode();
    void setCode(String code);
    
    String getName();
    void setName(String name);
}
