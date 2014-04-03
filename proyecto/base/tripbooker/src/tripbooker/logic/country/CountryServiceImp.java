package tripbooker.logic.country;

import java.util.ArrayList;
import java.util.List;
import tripbooker.dto.bean.country.ICountryBean;
import tripbooker.dto.domain.country.ICountryDO;
import tripbooker.dto.mapper.DTOMapper;
import tripbooker.integration.factory.DAOFactory;
import tripbooker.persistence.database.exception.TransactionException;
import tripbooker.persistence.database.manager.TransactionManager;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public class CountryServiceImp implements ICountryService{

    @Override
    public List<ICountryBean> getAllCountries() {
        ArrayList<ICountryBean> result = new ArrayList<ICountryBean>();
        try {
            List<ICountryDO> list = DAOFactory.getInstance().getCountryDAO().getAllCountries();
            for(ICountryDO countryDO : list){
                result.add(DTOMapper.getInstance().getCountryBean(countryDO));
            }
        } catch (TransactionException ex) {
            //TODO
        }
        return result;
    }

    @Override
    public boolean persistCountry(ICountryBean countryBean) {
        boolean result = false;
        try {
            TransactionManager.getInstance().begin();
            ICountryDO countryDO = DTOMapper.getInstance().getCountryDO(countryBean);
            result = DAOFactory.getInstance().getCountryDAO().persistCountry(countryDO);
            TransactionManager.getInstance().commit();
        } catch (TransactionException ex) {
            try {
                TransactionManager.getInstance().rollback();
            } catch (TransactionException ex1) {
                //TODO - Rollback error
            }
        }finally{
            try {
                TransactionManager.getInstance().close();
            } catch (TransactionException ex) {
                //TODO - close error
            }
        }
        return result;
    }

    @Override
    public boolean removeCountry(ICountryBean countryBean) {
        boolean result = false;
        try {
            TransactionManager.getInstance().begin();
            ICountryDO countryDO = DAOFactory.getInstance().getCountryDAO().getCountryByCode(countryBean.getCode());
            if(countryDO != null){
                result = DAOFactory.getInstance().getCountryDAO().removeCountry(countryDO.getCountryID());
                TransactionManager.getInstance().commit();
            }
        } catch (TransactionException ex) {
            try {
                TransactionManager.getInstance().rollback();
            } catch (TransactionException ex1) {
                //TODO - Rollback error
            }
        }finally{
            try {
                TransactionManager.getInstance().close();
            } catch (TransactionException ex) {
                //TODO - Close error
            }
        }
        return result;
    }

}
