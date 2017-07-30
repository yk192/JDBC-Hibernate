package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Bi.Util;
import dao.EmloyeeDao;
import entity.Employee;


public class EmloyeeService extends Util implements EmloyeeDao {

    Connection connection = getConnection();

    @Override
    public void add(Employee employee) throws SQLException {
	// TODO Auto-generated method stub
	PreparedStatement preparedStatement = null;
	String SQL = "insert into employee(id, first_name, last_name, dirthday, address_id ) value(?, ?, ?, ?, ?)";
	try {
	    preparedStatement = connection.prepareStatement(SQL);
	    preparedStatement.setInt(1, employee.getId());
	    preparedStatement.setString(2, employee.getFirstName());
	    preparedStatement.setString(3, employee.getLastName());
	    preparedStatement.setDate(4, employee.getBirthday());
	    preparedStatement.setInt(5, employee.getAddressId());

	    preparedStatement.executeUpdate();

	} catch (SQLException e) {
	    e.printStackTrace();
	} finally {
	    if (preparedStatement != null) {
		preparedStatement.close();
	    }
	    if (connection != null) {
		connection.close();
	    }

	}

    }

    @Override
    public List<Employee> getAll() throws SQLException {
	// TODO Auto-generated method stub
	List<Employee> employeeList = new ArrayList<>();

	String SQL = "select id, firstNmae, lastName, birthday, addressId from employee";

	Statement statement = null;
	try {
	    statement = connection.createStatement();

	    ResultSet resltSet = statement.executeQuery(SQL);

	    while (resltSet.next()) {
		Employee employee = new Employee();
		employee.setId(resltSet.getInt("id"));
		employee.setFirstName(resltSet.getString("firstName"));
		employee.setLastName(resltSet.getString("lastName"));
		employee.setBirthday(resltSet.getDate("birthday"));
		employee.setAddressId(resltSet.getInt("addressId"));

		employeeList.add(employee);

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

	return employeeList;
    }

    @Override
    public Employee getById(Long id) throws SQLException {
	// TODO Auto-generated method stub
	PreparedStatement prepareStatemnt = null;
	String sql = "select id, firstName, lastName, birthday, addressId from employee where id = ?";

	Employee employee = new Employee();
	try {
	    prepareStatemnt = connection.prepareStatement(sql);
	    prepareStatemnt.setLong(1, id);

	    ResultSet resultSet = prepareStatemnt.executeQuery();
	    employee.setId(resultSet.getInt("id"));
	    employee.setFirstName(resultSet.getString("firstName"));
	    employee.setLastName(resultSet.getString("lastName"));
	    employee.setBirthday(resultSet.getDate("birthday"));
	    employee.setAddressId(resultSet.getInt("addressId"));

	    prepareStatemnt.executeUpdate();

	} catch (SQLException e) {
	    e.printStackTrace();
	} finally {
	    if (prepareStatemnt != null) {
		prepareStatemnt.close();
	    }
	    if (connection != null) {
		connection.close();
	    }
	}

	return employee;
    }

    @Override
    public void update(Employee employee) throws SQLException {
	// TODO Auto-generated method stub
	PreparedStatement preparedStatement = null;
	String sql = "update employee set id = ?, firstName = ?, lastName = ?, birthday = ?, addressId = ? where id = ?";

	try {
	    preparedStatement = connection.prepareStatement(sql);
	    preparedStatement.setLong(1, employee.getId());
	    preparedStatement.setString(2, employee.getFirstName());
	    preparedStatement.setString(3, employee.getLastName());
	    preparedStatement.setDate(4, employee.getBirthday());
	    preparedStatement.setInt(5, employee.getAddressId());

	    preparedStatement.executeUpdate();

	} catch (Exception e) {
	    e.printStackTrace();
	} finally {
	    if (preparedStatement != null) {
		preparedStatement.close();
	    }
	    if (connection != null) {
		connection.close();
	    }
	}

    }

    @Override
    public void remove(Employee employee) throws SQLException {
	// TODO Auto-generated method stub

	PreparedStatement preparedStatement = null;
	String sql = "delete from employee where id = ?";

	try {
	    preparedStatement = connection.prepareStatement(sql);

	    preparedStatement.setLong(1, employee.getId());

	    preparedStatement.executeUpdate();

	} catch (Exception e) {
	    e.printStackTrace();
	} finally {
	    if (preparedStatement != null) {
		preparedStatement.close();
	    }
	    if (connection != null) {
		connection.close();
	    }
	}

    }

}
