package tripbooker.logic.airport;

import java.util.List;
import tripbooker.dto.bean.airport.IAirportBean;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public interface IAirportService {
    List<IAirportBean> getAllAirports();
    List<IAirportBean> getAirportsByCity(String code);
    boolean persistAirport(IAirportBean airportBean);
    boolean removeAirport(IAirportBean airportBean);
}
