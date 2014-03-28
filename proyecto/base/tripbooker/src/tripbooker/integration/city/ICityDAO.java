package tripbooker.integration.city;

import java.util.List;
import tripbooker.dto.domain.city.ICityDO;
import tripbooker.persistence.database.exception.TransactionException;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public interface ICityDAO {
    List<ICityDO> getAllCities()throws TransactionException;
    ICityDO getCityByID(int id)throws TransactionException;
    ICityDO getCityByCode(String code)throws TransactionException;
    boolean removeCity(int id) throws TransactionException;
    boolean persistCity(ICityDO city) throws TransactionException;
}
