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
    IAirlineDO getAirlineByCode(String code)throws TransactionException;
    boolean removeAirline(int id) throws TransactionException;
    boolean persistAirline(IAirlineDO airline) throws TransactionException;
}

