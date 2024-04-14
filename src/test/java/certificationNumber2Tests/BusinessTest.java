package certificationNumber2Tests;

import certificationNumber2.ControlJDBC;
import certificationNumber2.XClientService;
import certificationNumber2.model.Employee;
import certificationNumber2.model.InputValue;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BusinessTest {
    private XClientService client;
    private ControlJDBC controlJDBC;
    private Integer compID = 0;
    private Integer empID = 0;
    private List<Integer> listOfEmployee = new ArrayList<>();


    @BeforeEach
    protected void setUp() {
        String connectionString = "jdbc:postgresql://dpg-cn1542en7f5s73fdrigg-a.frankfurt-postgres.render.com/x_clients_xxet";
        String user = "x_clients_user";
        String pass = "x7ngHjC1h08a85bELNifgKmqZa8KIR40";
        client = new XClientService();
        controlJDBC = new ControlJDBC(connectionString, user, pass);
    }
    @AfterEach
    protected void tearDown() {
        if (!listOfEmployee.isEmpty()) {
            listOfEmployee.forEach(x -> {
                controlJDBC.deleteEmp(x);
            });
            listOfEmployee.clear();
        }
        if (empID != 0) {
            controlJDBC.deleteEmp(empID);
            empID = 0;
        }
        if (compID != 0) {
            controlJDBC.deleteComp(compID);
            compID = 0;
        }
        controlJDBC.close();
    }

    @Test
    @Tag("all")
    @Tag("post")
    @Tag("create")
    @DisplayName("Создание сотрудника")
    protected void createNewEmployee() {

        String token_admin = client.getToken("tecna", "tecna-fairy");
        compID = controlJDBC.createCompany("CompanyForEmployee");
        empID = client.createEmployee(InputValue._FIRSTNAME.getValue(), InputValue._LASTNAME.getValue(),
                InputValue._MIDDLENAME.getValue(), InputValue._EMAIL.getValue(), InputValue._URL.getValue(),
                InputValue._PHONE.getValue(), InputValue._BIRTHDATE.getValue(), true, compID, token_admin);

        Employee employee = null;

        employee = controlJDBC.selectEmployeeInfo(empID);

        assertEquals(employee.firstName(), InputValue._FIRSTNAME.getValue());
        assertEquals(employee.lastName(), InputValue._LASTNAME.getValue());
        assertEquals(employee.middleName(), InputValue._MIDDLENAME.getValue());
    }

    @Test
    @Tag("all")
    @Tag("post")
    @Tag("create")
    @DisplayName("Попытка создания сотрудника с некорректными данными")
    protected void createInvalidEmployee() {

        String token_admin = client.getToken("tecna", "tecna-fairy");

        compID = controlJDBC.createCompany("CompanyForEmployee");

        List<String> errMessage = client.createInvalidEmployee(InputValue._BLANK.getValue(), InputValue._LASTNAME.getValue(),
                InputValue._MIDDLENAME.getValue(), InputValue._EMAIL.getValue(), InputValue._URL.getValue(),
                InputValue._PHONE.getValue(), InputValue._BIRTHDATE.getValue(), true, compID, token_admin);

        assertEquals("firstName should not be empty", errMessage.get(0));

    }

    @Test
    @Tag("all")
    @Tag("post")
    @Tag("create")
    @DisplayName("Создание сотрудника без отчества")
    protected void createNewEmployeeWithoutMiddleName() {

        String token_admin = client.getToken("tecna", "tecna-fairy");

        compID = controlJDBC.createCompany("CompanyForEmployee");

        empID = client.createEmployee(InputValue._FIRSTNAME.getValue(), InputValue._LASTNAME.getValue(),
                InputValue._BLANK.getValue(), InputValue._EMAIL.getValue(), InputValue._URL.getValue(),
                InputValue._PHONE.getValue(), InputValue._BIRTHDATE.getValue(), true, compID, token_admin);

        Employee employee = null;

        employee = controlJDBC.selectEmployeeInfo(empID);

        assertEquals(employee.firstName(), InputValue._FIRSTNAME.getValue());
        assertEquals(employee.lastName(), InputValue._LASTNAME.getValue());
        assertEquals(employee.middleName(), "");
    }

    @Test
    @Tag("all")
    @Tag("post")
    @Tag("create")
    @DisplayName("Создание сотрудника c токеном клиента")
    protected void createNewEmployeeWithoutAdminRights() {

        String token_user = client.getToken("musa", "music-fairy");

        compID = controlJDBC.createCompany("CompanyForEmployee");

        empID = client.createEmployee(InputValue._FIRSTNAME.getValue(), InputValue._LASTNAME.getValue(),
                InputValue._MIDDLENAME.getValue(), InputValue._EMAIL.getValue(), InputValue._URL.getValue(),
                InputValue._PHONE.getValue(), InputValue._BIRTHDATE.getValue(), true, compID, token_user);

        Employee employee = null;

        employee = controlJDBC.selectEmployeeInfo(empID);

        assertEquals(employee.firstName(), InputValue._FIRSTNAME.getValue());
        assertEquals(employee.lastName(), InputValue._LASTNAME.getValue());
        assertEquals(employee.middleName(), InputValue._MIDDLENAME.getValue());
    }

    @Test
    @Tag("all")
    @Tag("get")
    @Tag("getInfo")
    @DisplayName("Получение инфо сотрудника по ID")
    protected void getEmployeeInfoById() {

            compID = controlJDBC.createCompany("Company for Employee");
            empID = controlJDBC.createEmployee(InputValue._FIRSTNAME.getValue(), InputValue._LASTNAME.getValue(),
                    InputValue._MIDDLENAME.getValue(), InputValue._EMAIL.getValue(),
                    InputValue._PHONE.getValue(), InputValue._BIRTHDATE.getValue(), compID);

        Employee employee = client.getInfoEmployee(empID);

        assertEquals(employee.firstName(), InputValue._FIRSTNAME.getValue());
        assertEquals(employee.lastName(), InputValue._LASTNAME.getValue());
        assertEquals(employee.companyId(), compID);
        assertNull(employee.url());
    }

    @Test
    @Tag("all")
    @Tag("get")
    @Tag("getList")
    @DisplayName("Получение списка сотрудников по ID компании")
    protected void getListEmployeeForCompanyById() {
            compID = controlJDBC.createCompany("Company for Duo");
            empID = controlJDBC.createEmployee(InputValue._FIRSTNAME.getValue(), InputValue._LASTNAME.getValue(),
                    InputValue._MIDDLENAME.getValue(), InputValue._EMAIL.getValue(),
                    InputValue._PHONE.getValue(), InputValue._BIRTHDATE.getValue(), compID);
            listOfEmployee.add(empID);
            empID = controlJDBC.createEmployee(InputValue._FIRSTNAME.getValue(), InputValue._LASTNAME.getValue(),
                    InputValue._MIDDLENAME.getValue(), InputValue._EMAIL.getValue(),
                    InputValue._PHONE.getValue(), InputValue._BIRTHDATE.getValue(), compID);
            listOfEmployee.add(empID);

        List<Employee> list = client.getEmployeeListForCompany(compID);
        assertEquals(2, list.size());
        list.forEach(x -> assertEquals(x.firstName(), InputValue._FIRSTNAME.getValue()));
        list.forEach(x -> assertEquals(x.lastName(), InputValue._LASTNAME.getValue()));
    }

    @Test
    @Tag("all")
    @Tag("patch")
    @DisplayName("Изменение email, isActive")
    protected void changeEmployeeById() {
        String token = client.getToken("musa", "music-fairy");
            compID = controlJDBC.createCompany("Company for change Employee ifo");
            empID = controlJDBC.createEmployee("Alex", "Old", "", "a184829@mail.ru",
                    "877747742", "2000-03-03", compID);
        Employee employee = client.changeEmployeeInfoId(empID,
                InputValue._EMAIL.getValue(), InputValue._URL.getValue(),
                InputValue._PHONE.getValue(), false, token);

        assertFalse(employee.isActive());
        assertEquals(employee.url(), InputValue._URL.getValue());
        assertEquals(employee.email(), InputValue._EMAIL.getValue());
    }
}
