package tripbooker.dto.bean.ticket;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public class TicketBean implements ITicketBean{
    private String code;
    private String userCode;

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getUserCode() {
        return userCode;
    }

    @Override
    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    @Override
    public String toString() {
        return "TicketBean{" + "code=" + code + ", userCode=" + userCode + '}';
    }
}
