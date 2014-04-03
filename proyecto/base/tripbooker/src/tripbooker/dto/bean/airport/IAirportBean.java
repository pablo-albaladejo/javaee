package tripbooker.dto.bean.airport;

import java.io.Serializable;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public interface IAirportBean extends Serializable{
    String getCode();
    void setCode(String code);

    String getName();
    void setName(String name);

    String getCityCode();
    void setCityCode(String cityCode);
}
