package tripbooker.dto.bean.user;

import java.io.Serializable;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public interface IUserBean extends Serializable{
    String getCode();
    void setCode(String code);
}
