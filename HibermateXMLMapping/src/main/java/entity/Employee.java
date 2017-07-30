package entity;

import java.sql.Date;
import java.util.Set;

public class Employee {

    private Long id;
    private String firstName;
    private String lastName;
    private Date birthday;
    private Address address;
    private Set<Project> project;

    public Employee() {

    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
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

    public Address getAddress() {
	return address;
    }

    public void setAddress(Address address) {
	this.address = address;
    }

    public Set<Project> getProject() {
	return project;
    }

    public void setProject(Set<Project> project) {
	this.project = project;
    }

    @Override
    public String toString() {
	return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", birthday=" + birthday
		+ ", address=" + address + "]";
    }

}
