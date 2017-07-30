package dao;

import java.sql.SQLException;
import java.util.List;

import entity.Address;

public interface AddressDao {

    // create one address
    void add(Address address) throws SQLException;

    // read all
    List<Address> getAll() throws SQLException;

    // read one address by id
    Address getById(int id) throws SQLException;

    // update one address
    void update(Address address) throws SQLException;

    // delete obe address
    void remove(Address address) throws SQLException;

}
