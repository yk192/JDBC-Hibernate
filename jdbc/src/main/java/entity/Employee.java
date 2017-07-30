package entity;

import java.sql.Date;

public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private Date birthday;
    private int addressId;

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getFirstName() {
	return firstName;
    }

    public void setFirstName(String firstName) {
	this.firstName = firstName;
    }

    public String getLastName() {
	return lastName;
    }

    public void setLastName(String lastName) {
	this.lastName = lastName;
    }

    public Date getBirthday() {
	return birthday;
    }

    public void setBirthday(Date birthday) {
	this.birthday = birthday;
    }

    public int getAddressId() {
	return addressId;
    }

    public void setAddressId(int adressId) {
	this.addressId = adressId;
    }

    @Override
    public String toString() {
	return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", birthday=" + birthday
		+ ", addressId=" + addressId + "]";
    }

}
