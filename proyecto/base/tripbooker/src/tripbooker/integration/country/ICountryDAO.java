package tripbooker.integration.country;

import java.util.List;
import tripbooker.dto.domain.country.ICountryDO;
import tripbooker.persistence.database.exception.TransactionException;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public interface ICountryDAO {
    List<ICountryDO> getAllCountries()throws TransactionException;
    ICountryDO getCountryByID(int id)throws TransactionException;
    ICountryDO getCountryByCode(String code)throws TransactionException;
    boolean persistCountry(ICountryDO country) throws TransactionException;
    boolean removeCountry(int id) throws TransactionException;
}
