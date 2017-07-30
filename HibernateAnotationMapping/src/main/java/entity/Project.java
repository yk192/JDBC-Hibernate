package entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PROJECT")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "TITLE")
    private String title;

    @ManyToMany(mappedBy = "projects")
    private Set<Employee> employees;

    public long getId() {
	return id;
    }

    public void setId(long id) {
	this.id = id;
    }

    public String getTitle() {
	return title;
    }

    public void setTitle(String title) {
	this.title = title;
    }

    public Set<Employee> getEmployees() {
	return employees;
    }

    public void setEmployees(Set<Employee> employees) {
	this.employees = employees;
    }

    @Override
    public String toString() {
	return "Project [id=" + id + ", title=" + title + "]";
    }

}
