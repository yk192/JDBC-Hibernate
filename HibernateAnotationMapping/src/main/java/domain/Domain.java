package domain;

import java.sql.Date;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;

import bi.HibernateUtil;
import entity.Address;
import entity.Employee;
import entity.Project;

public class Domain {

    public static void main(String[] args) {
	Session session = HibernateUtil.getSessionFactory().openSession();
	session.beginTransaction();

	Address address = new Address();
	address.setCountry("UA");
	address.setCity("Lviv");
	address.setStreet("Center");
	address.setPostCode("2548");

	Employee employee = new Employee();
	employee.setFirstName("Test");
	employee.setLastName("Tetstov");

	Calendar calendar = Calendar.getInstance();
	calendar.set(1990, Calendar.MARCH, 1);
	employee.setBirthday(new Date(calendar.getTime().getTime()));

	employee.setAddress(address);

	Project project = new Project();
	project.setTitle("test");

	Set<Employee> employees = new HashSet<Employee>();
	employees.add(employee);
	project.setEmployees(employees);

	Set<Project> projects = new HashSet<Project>();
	projects.add(project);
	employee.setProjects(projects);

	session.save(address);
	session.save(employee);

	session.getTransaction().commit();
	HibernateUtil.shutDown();

    }

}
