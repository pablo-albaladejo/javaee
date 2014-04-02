package tripbooker.dto.bean.aircraft;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public interface IAircraftBean extends Serializable{
    String getManufacter();
    void setManufacter(String manufacter);

    String getModel();
    void setModel(String model);

    Date getDate();
    void setDate(Date date);

    int getSeats();
    void setSeats(int seats);
}
