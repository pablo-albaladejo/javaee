package tripbooker.integration.airline;

import java.util.List;
import tripbooker.dto.domain.airline.IAirlineDO;
import tripbooker.persistence.database.exception.TransactionException;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public interface IAirlineDAO {
    List<IAirlineDO> getAllAirlines()throws TransactionException;
    IAirlineDO getAirlineByID(int id)throws TransactionException;
    boolean removeAirline(int id) throws TransactionException;
    boolean insertAirline(IAirlineDO airline) throws TransactionException;
}

