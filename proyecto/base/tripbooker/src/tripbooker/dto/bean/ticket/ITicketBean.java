package tripbooker.dto.bean.ticket;

import java.io.Serializable;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public interface ITicketBean extends Serializable{
    String getCode();
    void setCode(String code);

    String getUserCode();
    void setUserCode(String userCode);
}
