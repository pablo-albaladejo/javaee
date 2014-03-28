package tripbooker.dto.bean.country;

import java.io.Serializable;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public interface ICountryBean extends Serializable{
    String getCode();
    void setCode(String code);

    String getName();
    void setName(String name);
}
