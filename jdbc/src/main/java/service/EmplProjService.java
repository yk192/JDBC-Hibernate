package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Bi.Util;
import dao.EmplProjDao;
import entity.EmplProj;

public class EmplProjService extends Util implements EmplProjDao {

    Connection connection = getConnection();

    @Override
    public void add(EmplProj emplProj) throws SQLException {
	// TODO Auto-generated method stub
	PreparedStatement preparedStatement = null;
	String sql = "insert into emplProj (empolyeeId, projectId) valus(?, ?)";

	try {
	    preparedStatement = connection.prepareStatement(sql);

	    preparedStatement.setLong(1, emplProj.getEmployeeId());
	    preparedStatement.setLong(2, emplProj.getProjectId());

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
    public List<EmplProj> getAll() throws SQLException {
	// TODO Auto-generated method stub
	List<EmplProj> emplProjList = new ArrayList<>();
	String sql = "select employeeId, projectId from EmplProj";

	Statement statement = null;
	try {
	    statement = connection.createStatement();

	    ResultSet resultSet = statement.executeQuery(sql);

	    while (resultSet.next()) {
		EmplProj emplProj = new EmplProj();
		emplProj.setEmployeeId(resultSet.getInt("employeeId"));
		emplProj.setProjectId(resultSet.getInt("projectId"));

		emplProjList.add(emplProj);
	    }

	} catch (Exception e) {
	    e.printStackTrace();
	} finally {
	    if (statement != null) {
		statement.close();
	    }
	    if (connection != null) {
		connection.close();
	    }
	}

	return emplProjList;
    }

    @Override
    public EmplProj getByEmployeeIdAndProjectId(Long employeeId, Long projectId) throws SQLException {
	// TODO Auto-generated method stub
	PreparedStatement preparedStatement = null;
	String sql = "select employeeId, projectId from EmplProj  where employeeId = ? and projectId = ?";

	EmplProj emplProj = new EmplProj();
	try {
	    preparedStatement = connection.prepareStatement(sql);
	    preparedStatement.setLong(1, employeeId);
	    preparedStatement.setLong(1, projectId);

	    ResultSet resultSet = preparedStatement.executeQuery();
	    emplProj.setEmployeeId(resultSet.getInt("employeeId"));
	    emplProj.setProjectId((int) resultSet.getLong("projectId"));

	    preparedStatement.executeUpdate();

	} catch (Exception e) {
	    // TODO: handle exception
	    e.printStackTrace();
	}
	finally {
	    if (preparedStatement != null) {
		preparedStatement.close();
	    }
	    if (connection != null) {
		connection.close();
	    }
	}

	return emplProj;
    }

    @Override
    public void update(EmplProj emplProj) throws SQLException {
	// TODO Auto-generated method stub
	PreparedStatement preparedStatement = null;
	String sql = "update EmplProj set empolyeeId = ?, projectId = ? where employeeId = ? and projectId = ?";

	try {
	    preparedStatement = connection.prepareStatement(sql);

	    preparedStatement.setLong(1, emplProj.getEmployeeId());
	    preparedStatement.setLong(1, emplProj.getProjectId());

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
    public void remove(EmplProj emplProj) throws SQLException {
	// TODO Auto-generated method stub
	PreparedStatement preparedStatement = null;
	String sql = "delete from EmplProj where employeeId = ? and projectId = ?";

	try {
	    preparedStatement = connection.prepareStatement(sql);

	    preparedStatement.setLong(1, emplProj.getEmployeeId());
	    preparedStatement.setLong(1, emplProj.getProjectId());

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
