package tripbooker.integration.country;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import tripbooker.dto.domain.country.ICountryDO;
import tripbooker.dto.domain.factory.DOFactory;
import tripbooker.integration.factory.DAO;
import tripbooker.persistence.database.exception.TransactionException;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public class CountryDAOImp extends DAO implements ICountryDAO {

    private void copyResultCountryData(ResultSet result, ICountryDO country) throws SQLException {
        country.setCountryID(result.getInt(1));
        country.setCode(result.getString(2));
        country.setName(result.getString(3));
    }
    
    @Override
    public List<ICountryDO> getAllCountries() throws TransactionException {
        List<ICountryDO> list = new ArrayList<ICountryDO>();
        String query = "SELECT * FROM country";
        try {
            this.resultSet = this.statement.executeQuery(query);
            while (this.resultSet.next()) {
                ICountryDO aircraft = DOFactory.getInstance().getCountryDO();
                copyResultCountryData(resultSet, aircraft);
                list.add(aircraft);
            }
        } catch (SQLException e) {
                throw new TransactionException(e);
        }
        return list;        
    }

    @Override
    public ICountryDO getCountryByID(int id) throws TransactionException {
        ICountryDO country = null;

        String query = "SELECT * FROM country"
                + " WHERE countryID = '" + id + "'";
        try {
            this.resultSet = this.statement.executeQuery(query);
            if (resultSet.next()) {
                country = DOFactory.getInstance().getCountryDO();
                copyResultCountryData(resultSet, country);
            } else {
                country = null;
            }
        } catch (SQLException e) {
            throw new TransactionException(e);
        }
        return country;
    }

    @Override
    public ICountryDO getCountryByCode(String code) throws TransactionException {
        ICountryDO country = null;

        String query = "SELECT * FROM country"
                + " WHERE code = '" + code + "'";
        try {
            this.resultSet = this.statement.executeQuery(query);
            if (resultSet.next()) {
                country = DOFactory.getInstance().getCountryDO();
                copyResultCountryData(resultSet, country);
            } else {
                country = null;
            }
        } catch (SQLException e) {
            throw new TransactionException(e);
        }
        return country;
    }

    @Override
    public ICountryDO getCountryByName(String name) throws TransactionException {
        ICountryDO country = null;

        String query = "SELECT * FROM country"
                + " WHERE name = '" + name + "'";
        try {
            this.resultSet = this.statement.executeQuery(query);
            if (resultSet.next()) {
                country = DOFactory.getInstance().getCountryDO();
                copyResultCountryData(resultSet, country);
            } else {
                country = null;
            }
        } catch (SQLException e) {
            throw new TransactionException(e);
        }
        return country;
    }
    
    @Override
    public boolean persistCountry(ICountryDO country) throws TransactionException {
        boolean InsertActionResult = false;
        String query = "";
        
        if(this.getCountryByID(country.getCountryID()) != null){
            query = "UPDATE country SET " 
                + "code = '" + country.getCode() +"', "
                + "name = '" + country.getName()+"' "
                + "WHERE countryID = '" + country.getCountryID()+ "'";
        }else{
            query = "INSERT INTO country"
                    + " (`code`, `name`) VALUES ("
                    + "'" + country.getCode()+ "', "
                    + "'" + country.getName() + "'"
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

    @Override
    public boolean removeCountry(int id) throws TransactionException {
        boolean deleteActionResult = false;
        String query = "DELETE FROM  country"
                + " WHERE countryID = '" + id + "'";
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

}
