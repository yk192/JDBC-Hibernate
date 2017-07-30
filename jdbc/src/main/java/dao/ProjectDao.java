package dao;

import java.sql.SQLException;
import java.util.List;

import entity.Project;

public interface ProjectDao {

    // create one project
    void add(Project project) throws SQLException;

    // read all
    List<Project> getAll() throws SQLException;

    // read one project by id
    Project getById(Long id) throws SQLException;

    // update one project
    void update(Project project) throws SQLException;

    // delete obe project
    void remove(Project project) throws SQLException;

}
