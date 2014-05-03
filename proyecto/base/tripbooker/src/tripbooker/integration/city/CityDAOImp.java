package tripbooker.integration.city;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import tripbooker.dto.domain.city.ICityDO;
import tripbooker.dto.domain.factory.DOFactory;
import tripbooker.integration.factory.DAO;
import tripbooker.persistence.database.exception.TransactionException;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public class CityDAOImp extends DAO implements ICityDAO{

    private void copyResultCityData(ResultSet result, ICityDO city) throws SQLException {
        city.setCityID(result.getInt(1));
        city.setCode(result.getString(2));
        city.setName(result.getString(3));
        city.setCountryID(result.getInt(4));
    }
    
    @Override
    public List<ICityDO> getAllCities() throws TransactionException {
        List<ICityDO> list = new ArrayList<ICityDO>();
        String query = "SELECT * FROM city";
        try {
            this.resultSet = this.statement.executeQuery(query);
            while (this.resultSet.next()) {
                ICityDO city = DOFactory.getInstance().getCityDO();
                copyResultCityData(resultSet, city);
                list.add(city);
            }
        } catch (SQLException e) {
                throw new TransactionException(e);
        }
        return list;
    }

    @Override
    public List<ICityDO> getAllCitiesByCountry(int countryID) throws TransactionException {
        List<ICityDO> list = new ArrayList<ICityDO>();
        String query = "SELECT * FROM city WHERE countryID = '"+countryID+"'";
        try {
            this.resultSet = this.statement.executeQuery(query);
            while (this.resultSet.next()) {
                ICityDO city = DOFactory.getInstance().getCityDO();
                copyResultCityData(resultSet, city);
                list.add(city);
            }
        } catch (SQLException e) {
                throw new TransactionException(e);
        }
        return list;
    }
    
    @Override
    public ICityDO getCityByID(int id) throws TransactionException {
        ICityDO city = null;

        String query = "SELECT * FROM city"
                + " WHERE cityID = '" + id + "'";
        try {
            this.resultSet = this.statement.executeQuery(query);
            if (resultSet.next()) {
                city = DOFactory.getInstance().getCityDO();
                copyResultCityData(resultSet, city);
            } else {
                city = null;
            }
        } catch (SQLException e) {
            throw new TransactionException(e);
        }
        return city;
    }

    @Override
    public ICityDO getCityByCode(String code) throws TransactionException {
        ICityDO city = null;
        String query = "SELECT * FROM city"
                + " WHERE code = '" + code + "'";
        try {
            this.resultSet = this.statement.executeQuery(query);
            if (resultSet.next()) {
                city = DOFactory.getInstance().getCityDO();
                copyResultCityData(resultSet, city);
            }
        } catch (SQLException e) {
            throw new TransactionException(e);
        }
        return city;
    }

    @Override
    public ICityDO getCityByName(String name) throws TransactionException {
        ICityDO city = null;
        String query = "SELECT * FROM city"
                + " WHERE name = '" + name + "'";
        try {
            this.resultSet = this.statement.executeQuery(query);
            if (resultSet.next()) {
                city = DOFactory.getInstance().getCityDO();
                copyResultCityData(resultSet, city);
            }
        } catch (SQLException e) {
            throw new TransactionException(e);
        }
        return city;
    }
    
    @Override
    public boolean removeCity(int id) throws TransactionException {
        boolean deleteActionResult = false;
        String query = "DELETE FROM  city"
                + " WHERE cityID = '" + id + "'";
        try {
            int numRows = this.statement.executeUpdate(query);
            if (numRows > 0) {
                deleteActionResult = true;
            }
        } catch (SQLException ex) {
            throw new TransactionException(ex);
        }
        return deleteActionResult;
    }

    @Override
    public boolean persistCity(ICityDO city) throws TransactionException {
         boolean InsertActionResult = false;
        String query = "";
        
        if(this.getCityByID(city.getCityID()) != null){
            query = "UPDATE city SET " 
                + "code = '" + city.getCode() +"', "
                + "name = '" + city.getName()+"', "
                + "countryID = '" + city.getCountryID()+"' "
                + "WHERE cityID = '" + city.getCityID() + "'";
        }else{
            query = "INSERT INTO city"
                    + " (`code`, `name`, `countryID`) VALUES ("
                    + "'" + city.getCode()+ "', "
                    + "'" + city.getName() + "',"
                    + "'" + city.getCountryID()+"' "
                    + ")";
        }
        try {
            int numRows = this.statement.executeUpdate(query);
            if (numRows > 0) {
                InsertActionResult = true;
            }
        } catch (SQLException ex) {
            throw new TransactionException(ex);
        }
        return InsertActionResult;
    }

}
