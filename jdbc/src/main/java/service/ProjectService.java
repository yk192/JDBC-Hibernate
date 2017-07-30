package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Bi.Util;
import dao.ProjectDao;
import entity.Project;

public class ProjectService extends Util implements ProjectDao {

    Connection connection = getConnection();

    @Override
    public void add(Project project) throws SQLException {
	// TODO Auto-generated method stub
	PreparedStatement preparedStatement = null;

	String sql = "insert into project (id, title) valus (?, ?)";
	try {

	    preparedStatement = connection.prepareStatement(sql);

	    preparedStatement.setInt(1, project.getId());
	    preparedStatement.setString(2, project.getTitle());

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
    public List<Project> getAll() throws SQLException {
	// TODO Auto-generated method stub
	List<Project> projectList = new ArrayList<>();
	String sql = "select id, title from project";

	Statement statement = null;
	try {
	    statement = connection.createStatement();

	    ResultSet resultSet = statement.executeQuery(sql);

	    while (resultSet.next()) {
		Project project = new Project();

		project.setId(resultSet.getInt("id"));
		project.setTitle(resultSet.getString("title"));

		projectList.add(project);
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

	return projectList;
    }

    @Override
    public Project getById(Long id) throws SQLException {
	// TODO Auto-generated method stub
	PreparedStatement preparedStatement = null;
	String sql = "select id title from project where id = ?";

	Project project = new Project();

	try {
	    preparedStatement = connection.prepareStatement(sql);
	    preparedStatement.setLong(1, id);

	    ResultSet resultSet = preparedStatement.executeQuery();
	    project.setId(resultSet.getInt("id"));
	    project.setTitle(resultSet.getString("title"));

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

	return project;
    }

    @Override
    public void update(Project project) throws SQLException {
	// TODO Auto-generated method stub
	PreparedStatement preparedStatement = null;
	String sql = "update project set id = ?, title = ? where id = ?";

	try {
	    preparedStatement = connection.prepareStatement(sql);

	    preparedStatement.setInt(1, project.getId());
	    preparedStatement.setString(2, project.getTitle());

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
    public void remove(Project project) throws SQLException {
	// TODO Auto-generated method stub
	PreparedStatement preparedStatement = null;
	String sql = "delete from project where id = ?";

	try {
	    preparedStatement = connection.prepareStatement(sql);

	    preparedStatement.setInt(1, project.getId());
	    preparedStatement.setString(2, project.getTitle());

	    preparedStatement.executeUpdate();
	} catch (Exception e) {
	    // TODO: handle exception
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
