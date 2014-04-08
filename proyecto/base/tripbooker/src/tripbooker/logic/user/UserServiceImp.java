package tripbooker.logic.user;

import java.util.ArrayList;
import java.util.List;
import tripbooker.dto.bean.factory.BeanFactory;
import tripbooker.dto.bean.user.IUserBean;
import tripbooker.dto.domain.user.IUserDO;
import tripbooker.dto.mapper.DTOMapper;
import tripbooker.integration.factory.DAOFactory;
import tripbooker.persistence.database.exception.TransactionException;
import tripbooker.persistence.database.manager.TransactionManager;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public class UserServiceImp implements IUserService{

    @Override
    public List<IUserBean> getAllUsers() {
        List<IUserBean> result = new ArrayList<IUserBean>();
        try{
            List<IUserDO> list = DAOFactory.getInstance().getUserDAO().getAllUsers();
            for(IUserDO userDO : list){
                result.add(DTOMapper.getInstance().getUserBean(userDO));
            }
        }catch (TransactionException ex){
            //TODO
        }
        return result;
    }

    @Override
    public IUserBean getUserByCode(String code) {
        IUserBean userBean = BeanFactory.getInstance().getUserBean();
        try{
            IUserDO userDO = DAOFactory.getInstance().getUserDAO().getUserByCode(code);
            if(userDO != null){
                userBean = DTOMapper.getInstance().getUserBean(userDO);
            }
        }catch (TransactionException ex){
        
        }
        return userBean;
    }

    @Override
    public boolean removeUser(IUserBean userBean) {
        boolean result = false;
        try{
            TransactionManager.getInstance().begin();
            IUserDO userDO = DAOFactory.getInstance().getUserDAO().getUserByCode(userBean.getCode());
            if(userDO != null){
                result = DAOFactory.getInstance().getUserDAO().removeUser(userDO.getUserID());
            }
            TransactionManager.getInstance().commit();
        }catch (TransactionException ex){
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
    public boolean persistUser(IUserBean userBean) {
        boolean result = false;
        try{
            TransactionManager.getInstance().begin();
            IUserDO userDO = DTOMapper.getInstance().getUserDO(userBean);
            if(userDO != null){
                result = DAOFactory.getInstance().getUserDAO().persistUser(userDO);
            }
            TransactionManager.getInstance().commit();
        }catch (TransactionException ex){
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
