package tripbooker.dto.bean.user;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public class UserBean implements IUserBean{
    private String code;

    @Override
    public String getCode() {
        return code;
    }
    
    @Override
    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "UserBean{" + "code=" + code + '}';
    }
}
