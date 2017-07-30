package dao;

import java.sql.SQLException;
import java.util.List;

import entity.Employee;

public interface EmloyeeDao {
    // create one employee
    void add(Employee employee) throws SQLException;

    // read all
    List<Employee> getAll() throws SQLException;

    // read one employee by id
    Employee getById(Long id) throws SQLException;

    // update one employee
    void update(Employee employee) throws SQLException;

    // delete obe employee
    void remove(Employee employee) throws SQLException;

}
