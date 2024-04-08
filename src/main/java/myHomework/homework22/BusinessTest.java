package myHomework.homework22;

import myHomework.homework22.model.Employee;
import org.junit.jupiter.api.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BusinessTest {
    private XClientService client;
    private ControlJDBC controlJDBC;
    private Integer compID;
    private Integer empID;
    private List<Integer> listOfEmployee = new ArrayList<>();

    @BeforeEach
    public void setUp() throws SQLException {
        String connectionString = "jdbc:postgresql://dpg-cn1542en7f5s73fdrigg-a.frankfurt-postgres.render.com/x_clients_xxet";
        String user = "x_clients_user";
        String pass = "x7ngHjC1h08a85bELNifgKmqZa8KIR40";
        client = new XClientService();
        controlJDBC = new ControlJDBC(connectionString, user, pass);
    }

    @AfterEach
    public void tearDown() throws SQLException {
        if (!listOfEmployee.isEmpty()) {
            listOfEmployee.forEach(x -> {
                try {
                    controlJDBC.deleteEmp(x);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            });
            listOfEmployee.clear();
        }
        controlJDBC.deleteEmp(empID);
        controlJDBC.deleteComp(compID);
        controlJDBC.close();
    }

    @Test
    @Tag("all")
    @Tag("post")
    @Tag("create")
    @DisplayName("Создание сотрудника")
    public void createNewEmployee() {

        String token_admin = client.getToken("tecna", "tecna-fairy");
        try {
            compID = controlJDBC.createCompany("CompanyForEmployee");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        empID = client.createEmployee("Andrey", "Ovs", "AI", compID,
                "", "7823918123", "2000-10-02", true, token_admin);

        Employee employee = null;
        try {
            employee = controlJDBC.selectEmployeeInfo(empID);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        assertEquals(employee.firstName(), "Andrey");
        assertEquals(employee.lastName(), "Ovs");
        assertEquals(employee.middleName(), "AI");
    }

    @Test
    @Tag("all")
    @Tag("post")
    @Tag("create")
    @DisplayName("Создание сотрудника без отчества")
    public void createNewEmployeeWithoutMiddleName() {

        String token_admin = client.getToken("tecna", "tecna-fairy");
        try {
            compID = controlJDBC.createCompany("CompanyForEmployee");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        empID = client.createEmployee("Misha", "Tech", "", compID,
                "", "7823918123", "2000-10-02", true, token_admin);

        Employee employee = null;
        try {
            employee = controlJDBC.selectEmployeeInfo(empID);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        assertEquals(employee.firstName(), "Misha");
        assertEquals(employee.lastName(), "Tech");
        assertEquals(employee.middleName(), "");
    }

    @Test
    @Tag("all")
    @Tag("post")
    @Tag("create")
    @DisplayName("Создание сотрудника c токеном клиента")
    public void createNewEmployeeWithoutAdminRights() {

        String token_user = client.getToken("musa", "music-fairy");
        try {
            compID = controlJDBC.createCompany("CompanyForEmployee");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        empID = client.createEmployee("Misha", "Tech", "", compID,
                "", "7823918123", "2000-10-02", true, token_user);

        Employee employee = null;
        try {
            employee = controlJDBC.selectEmployeeInfo(empID);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        assertEquals(employee.firstName(), "Misha");
        assertEquals(employee.lastName(), "Tech");
        assertEquals(employee.middleName(), "");
    }

    @Test
    @Tag("all")
    @Tag("get")
    @Tag("getInfo")
    @DisplayName("Получение инфо сотрудника по ID")
    public void getEmployeeInfoById() {

        try {
            compID = controlJDBC.createCompany("Company for Employee");
            empID = controlJDBC.createEmployee("Egor", "Proshutin", "", "mail@mail.ru",
                    "89878787", "2000-02-02", compID);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        Employee employee = client.getInfoEmployee(empID);

        assertEquals(employee.firstName(), "Egor");
        assertEquals(employee.lastName(), "Proshutin");
        assertEquals(employee.companyId(), compID);
        assertNull(employee.url());
    }

    @Test
    @Tag("all")
    @Tag("get")
    @Tag("getList")
    @DisplayName("Получение списка сотрудников по ID компании")
    public void getListEmployeeForCompanyById() {

        try {
            compID = controlJDBC.createCompany("Company for Duo");
            empID = controlJDBC.createEmployee("Igor", "Prosto", "", "mail@mail.ru",
                    "8987873287", "2000-02-02", compID);
            listOfEmployee.add(empID);
            empID = controlJDBC.createEmployee("Igor", "Prosto", "", "mail@mail.ru",
                    "8987228787", "2000-02-02", compID);
            listOfEmployee.add(empID);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        List<Employee> list = client.getEmployeeListForCompany(compID);
        assertEquals(2, list.size());
        list.forEach(x -> assertEquals(x.firstName(), "Igor"));
        list.forEach(x -> assertEquals(x.lastName(), "Prosto"));
    }
}
