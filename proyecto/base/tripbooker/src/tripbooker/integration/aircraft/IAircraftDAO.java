package tripbooker.integration.aircraft;

import java.util.List;
import tripbooker.dto.domain.aircraft.IAircraftDO;
import tripbooker.persistence.database.exception.TransactionException;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public interface IAircraftDAO {
    List<IAircraftDO> getAllAircrafts()throws TransactionException;
    IAircraftDO getAircraftByID(int id)throws TransactionException;
    IAircraftDO getAircraftByModel(String model) throws TransactionException;
    boolean removeAircraft(int id) throws TransactionException;
    boolean persistAircraft(IAircraftDO aircraft) throws TransactionException;
}
