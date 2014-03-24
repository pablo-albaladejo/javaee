package tripbooker.dto.domain.airline;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public interface IAirlineDO {
    int getAirlineID();
    void setAirlineID(int airlineID);

    String getCode();
    void setCode(String code);

    String getName();
    void setName(String name);

    int getCountryID();
    void setCountryID(int countryID);
}
