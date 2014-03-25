package tripbooker.logic.facade;

import java.util.List;
import tripbooker.dto.bean.IFlightBean;
import tripbooker.logic.factory.ServiceFactory;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public class BusinessFacade implements IBusinessFacade{

    @Override
    public List<IFlightBean> getAllFlights(String airlineCode) {
        return ServiceFactory.getInstance().getFlightService().getAllFlights(airlineCode);
    }

}
