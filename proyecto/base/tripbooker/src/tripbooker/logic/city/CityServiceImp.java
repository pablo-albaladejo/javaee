package tripbooker.logic.city;

import java.util.ArrayList;
import java.util.List;
import tripbooker.dto.bean.city.ICityBean;
import tripbooker.dto.domain.city.ICityDO;
import tripbooker.dto.domain.country.ICountryDO;
import tripbooker.dto.mapper.DTOMapper;
import tripbooker.integration.factory.DAOFactory;
import tripbooker.persistence.database.exception.TransactionException;
import tripbooker.persistence.database.manager.TransactionManager;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public class CityServiceImp implements ICityService{

    @Override
    public List<ICityBean> getAllCities() {
        List<ICityBean> result = new ArrayList<ICityBean>();
        try {
             List<ICityDO> list = DAOFactory.getInstance().getCityDAO().getAllCities();
             for(ICityDO cityDO : list){
                 ICountryDO countryDO = DAOFactory.getInstance().getCountryDAO().getCountryByID(cityDO.getCountryID());
                 if(countryDO != null){
                    result.add(DTOMapper.getInstance().getCityBean(cityDO,countryDO));
                 }
             }
        } catch (TransactionException ex) {
            //TODO
        }
        return result;
    }
    
    @Override
    public boolean persistCity(ICityBean cityBean) {
        boolean result = false;
        try {
            TransactionManager.getInstance().begin();
            ICountryDO countryDO = DAOFactory.getInstance().getCountryDAO().getCountryByCode(cityBean.getCountryCode());
            if(countryDO != null){
               ICityDO cityDOTemp = DAOFactory.getInstance().getCityDAO().getCityByCode(cityBean.getCode());

               ICityDO cityDO = DTOMapper.getInstance().getCityDO(cityBean,countryDO);
               if(cityDOTemp != null){ //if exists, just modify, not to insert.
                   cityDO.setCityID(cityDOTemp.getCityID());
               }
               result = DAOFactory.getInstance().getCityDAO().persistCity(cityDO);
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

    @Override
    public boolean removeCity(ICityBean cityBean) {
        boolean result = false;
        try {
            TransactionManager.getInstance().begin();
            ICityDO cityDO = DAOFactory.getInstance().getCityDAO().getCityByCode(cityBean.getCode());
            if(cityDO != null){
                result = DAOFactory.getInstance().getCityDAO().removeCity(cityDO.getCityID());
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
                //TODO - Close Error
            }
        }
        return result;
    }

}
