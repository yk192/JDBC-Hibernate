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

	Session session = HibernateUtil.getSessionfactory().openSession();

	session.beginTransaction();

	Address address = new Address();
	address.setCountry("UA");
	address.setCity("Kyiv");
	address.setStreet("Khreschatyk");
	address.setPostCode("0403");

	Employee employee = new Employee();
	employee.setFirstName("test");
	employee.setLastName("test");

	Calendar calendar = Calendar.getInstance();
	calendar.set(1992, Calendar.MARCH, 1);
	employee.setBirthday(new Date(calendar.getTime().getTime()));

	employee.setAddress(address);

	Project project = new Project();
	project.setTitle("5678");

	Set<Project> projects = new HashSet<Project>();
	employee.setProject(projects);

	session.save(address);
	session.save(employee);

	session.getTransaction().commit();
	HibernateUtil.shutDown();

    }

}
