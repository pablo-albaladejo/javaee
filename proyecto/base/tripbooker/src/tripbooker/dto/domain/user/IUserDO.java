package tripbooker.dto.domain.user;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public interface IUserDO {
    int getUserID();
    void setUserID(int userID);
    
    String getCode();
    void setCode(String code);
}
