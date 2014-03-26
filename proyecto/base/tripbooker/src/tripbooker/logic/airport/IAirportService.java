package tripbooker.logic.airport;

import tripbooker.dto.bean.airport.IAirportBean;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public interface IAirportService {
    boolean persistAirport(IAirportBean airportBean);
    boolean removeAirport(IAirportBean airportBean);
    boolean modifyAirport(IAirportBean airportBean);
}
