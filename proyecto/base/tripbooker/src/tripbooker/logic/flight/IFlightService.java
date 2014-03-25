package tripbooker.logic.flight;

import java.util.List;
import tripbooker.dto.bean.IFlightBean;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public interface IFlightService {
    List<IFlightBean> getAllFlights(String airlineCode);
}
