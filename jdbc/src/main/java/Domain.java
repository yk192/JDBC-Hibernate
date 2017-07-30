import Bi.Util;
import entity.Address;
import entity.Employee;
import service.AdressService;
import service.EmloyeeService;
import service.EmplProjService;
import service.ProjectService;

/*
 * Проверка соединения с БД
 * */
public class Domain {

    public static void main(String[] args) {

	Util util = new Util();
	util.getConnection();

	AdressService addressService = new AdressService();
	EmloyeeService employeeService = new EmloyeeService();
	EmplProjService emplProjService = new EmplProjService();
	ProjectService projectService = new ProjectService();

	Address address = new Address();
	address.setId(2);
	address.setCountry("UA");
	address.setCity("Orvianitsa");
	address.setStreet("Komarova");
	address.setPostCode("67890");

	Employee employee = new Employee();
	employee.setId(2);
	// employee.setFirstName("Yura");
	// employee.setLastName("Krasko");
	// Calendar calendar = Calendar.getInstance();
	// calendar.set(1992, 2, 4);
	// employee.setBirthday(new Date(calendar.getTime().getTime()));
	// employee.setAddressId(2);

	try {
	    // List<Address> adressList = addressService.getAll();
	    // for (Address a : adressList) {
	    // System.out.println(a);
	    // }

	    System.out.println(addressService.getById(1));

	} catch (Exception e) {
	    // TODO: handle exception
	    e.printStackTrace();

	}
    }

}
