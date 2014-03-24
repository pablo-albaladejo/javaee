package tripbooker.dto.factory;

import tripbooker.dto.domain.aircraft.AircraftDOImp;
import tripbooker.dto.domain.aircraft.IAircraftDO;
import tripbooker.dto.domain.airline.AirlineDOImp;
import tripbooker.dto.domain.airline.IAirlineDO;


/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public class DTOFactoryImp extends DTOFactory{

    @Override
    public IAirlineDO getAirlineDO() {
        return new AirlineDOImp();
    }

    @Override
    public IAircraftDO getAircraftDO() {
        return new AircraftDOImp();
    }

}
