package entity;

import java.util.Set;

public class Project {

    private Long id;
    private String title;
    private Set<Employee> employee;

    public Project() {

    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getTitle() {
	return title;
    }

    public void setTitle(String title) {
	this.title = title;
    }

    public Set<Employee> getEmployee() {
	return employee;
    }

    public void setEmployee(Set<Employee> employee) {
	this.employee = employee;
    }

    @Override
    public String toString() {
	return "Project [id=" + id + ", title=" + title + "]";
    }

}
