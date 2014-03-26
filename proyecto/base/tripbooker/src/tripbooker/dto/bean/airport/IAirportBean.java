package tripbooker.dto.bean.airport;

import java.io.Serializable;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public interface IAirportBean extends Serializable{
    public String getCode();
    public void setCode(String code);

    public String getName();
    public void setName(String name);

    public String getCity();
    public void setCity(String city);
}
