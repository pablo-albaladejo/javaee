package tripbooker.logic.facade;

import java.util.List;
import tripbooker.dto.bean.IFlightBean;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public interface IBusinessFacade {
    List<IFlightBean> getAllFlights(String airlineCode);
}
