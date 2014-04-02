package tripbooker.dto.domain.aircraft;

import java.util.Date;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public interface IAircraftDO {
    int getAirfarctID();
    void setAirfarctID(int airfarctID);
    
    String getManufacter();
    void setManufacter(String manufacter);
   
    String getModel();
    void setModel(String model);

    Date getDate();
    void setDate(Date date);

    int getSeats();
    void setSeats(int seats);
}
