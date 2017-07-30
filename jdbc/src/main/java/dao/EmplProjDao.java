package dao;

import java.sql.SQLException;
import java.util.List;

import entity.EmplProj;

public interface EmplProjDao {

    // create one emplProj
    void add(EmplProj emplProj) throws SQLException;

    // read all
    List<EmplProj> getAll() throws SQLException;

    // read one emplProj by id
    EmplProj getByEmployeeIdAndProjectId(Long employeeId, Long projectId) throws SQLException;

    // update one emplProj
    void update(EmplProj emplProj) throws SQLException;

    // delete obe EmplProjDao
    void remove(EmplProj emplProj) throws SQLException;

}
