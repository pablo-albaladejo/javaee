package tripbooker.logic.aircraft;

import java.util.List;
import tripbooker.dto.bean.aircraft.IAircraftBean;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public interface IAircraftService {
    List<IAircraftBean> getAllAircrafts();
    boolean persistAircraft(IAircraftBean aircraftBean);
    boolean removeAircraft(IAircraftBean aircraftBean);
}
