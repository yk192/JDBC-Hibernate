package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Bi.Util;
import dao.AddressDao;
import entity.Address;

public class AdressService extends Util implements AddressDao {

    Connection connection = getConnection();

    @Override
    public void add(Address address) throws SQLException {
	// TODO Auto-generated method stub

	PreparedStatement prepareStatement = null;
	String sql = "insert into address(id, country, city, street, post_code) values (?, ?, ?, ?, ?)";

	try {
	    prepareStatement = connection.prepareStatement(sql);
	    prepareStatement.setInt(1, address.getId());
	    prepareStatement.setString(2, address.getCountry());
	    prepareStatement.setString(3, address.getCity());
	    prepareStatement.setString(4, address.getStreet());
	    prepareStatement.setString(5, address.getPostCode());

	    prepareStatement.executeUpdate();

	} catch (SQLException e) {
	    e.printStackTrace();
	} finally {
	    if (prepareStatement != null) {
		prepareStatement.close();
	    }
	    if (connection != null) {
		connection.close();
	    }
	}

    }

    @Override
    public List<Address> getAll() throws SQLException {
	// TODO Auto-generated method stub

	List<Address> addressList = new ArrayList<>();

	String sql = "select id, country, city, street, post_code from address";

	Statement statement = null;
	try {

	    statement = connection.createStatement();

	    ResultSet resulSet = statement.executeQuery(sql);

	    while (resulSet.next()) {
		Address address = new Address();

		address.setId(resulSet.getInt("id"));
		address.setCountry(resulSet.getString("country"));
		address.setCity(resulSet.getString("city"));
		address.setStreet(resulSet.getString("street"));
		address.setPostCode(resulSet.getString("post_code"));

		addressList.add(address);
	    }

	} catch (SQLException e) {
	    e.printStackTrace();
	} finally {
	    if (statement != null) {
		statement.close();
	    }
	    if (connection != null) {
		connection.close();
	    }
	}

	return addressList;
    }

    @Override
    public Address getById(int i) throws SQLException {
	// TODO Auto-generated method stub

	PreparedStatement prepareStatement = null;

	String sql = "select id, country, city, street, post_code from address where id = ?";

	Address address = new Address();
	try {
	    prepareStatement = connection.prepareStatement(sql);
	    prepareStatement.setInt(1, i);

	    ResultSet resulSet = prepareStatement.executeQuery();
	    address.setId(resulSet.getInt("id"));
	    address.setCountry(resulSet.getString("country"));
	    address.setCity(resulSet.getString("city"));
	    address.setStreet(resulSet.getString("street"));
	    address.setPostCode(resulSet.getString("post_code"));

	    prepareStatement.executeUpdate();

	} catch (SQLException e) {
	    e.printStackTrace();
	} finally {
	    if (prepareStatement != null) {
		prepareStatement.close();
	    }
	    if (connection != null) {
		connection.close();
	    }

	}

	return address;
    }

    @Override
    public void update(Address address) throws SQLException {
	// TODO Auto-generated method stub
	PreparedStatement prepareStatement = null;
	String sql = "update address set country = ?, city = ?, street = ?, post_code = ? where id = ?";

	try {
	    prepareStatement = connection.prepareStatement(sql);
	    prepareStatement.setInt(1, address.getId());
	    prepareStatement.setString(2, address.getCountry());
	    prepareStatement.setString(3, address.getCity());
	    prepareStatement.setString(4, address.getStreet());
	    prepareStatement.setString(5, address.getPostCode());

	    prepareStatement.executeUpdate();

	} catch (SQLException e) {
	    e.printStackTrace();
	} finally {
	    if (prepareStatement != null) {
		prepareStatement.close();
	    }
	    if (connection != null) {
		connection.close();
	    }
	}

    }

    @Override
    public void remove(Address address) throws SQLException {
	// TODO Auto-generated method stub
	PreparedStatement prepareStatement = null;
	String sql = "delete from address where id = ?";

	try {
	    prepareStatement = connection.prepareStatement(sql);
	    prepareStatement.setLong(1, address.getId());

	    prepareStatement.executeUpdate();

	} catch (SQLException e) {
	    e.printStackTrace();
	} finally {
	    if (prepareStatement != null) {
		prepareStatement.close();
	    }
	    if (connection != null) {
		connection.close();
	    }
	}

    }



}
