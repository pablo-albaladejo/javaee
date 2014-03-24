package tripbooker.dto.domain.airport;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public interface IAirportDO {
    int getAirportID();
    void setAirportID(int airportID);

    String getCode();
    void setCode(String code);

    String getName();
    void setName(String name);

    int getCityID();
    void setCityID(int cityID);
}
