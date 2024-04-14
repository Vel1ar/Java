package certificationNumber2Tests;

import certificationNumber2.ControlJDBC;
import certificationNumber2.XClientService;
import certificationNumber2.model.ChangeEmployee;
import certificationNumber2.model.Employee;
import certificationNumber2.model.InputValue;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

public class ContractTest {
    private XClientService client;
    private ControlJDBC controlJDBC;
    private Integer compID = 0;
    private Integer empID = 0;
    private Integer secEmpID = 0;
    private List<Integer> listOfEmployee = new ArrayList<>();
    private String token_admin;

    @BeforeEach
    public void setUp() throws SQLException {
        String connectionString = "jdbc:postgresql://dpg-cn1542en7f5s73fdrigg-a.frankfurt-postgres.render.com/x_clients_xxet";
        String user = "x_clients_user";
        String pass = "x7ngHjC1h08a85bELNifgKmqZa8KIR40";
        client = new XClientService();
        controlJDBC = new ControlJDBC(connectionString, user, pass);
        controlJDBC = new ControlJDBC(connectionString, user, pass);
        token_admin = client.getToken("tecna", "tecna-fairy");
        compID = controlJDBC.createCompany("CompanyForEmployee");
        empID = client.createEmployee(InputValue._FIRSTNAME.getValue(), InputValue._LASTNAME.getValue(),
                InputValue._MIDDLENAME.getValue(), InputValue._EMAIL.getValue(), InputValue._URL.getValue(),
                InputValue._PHONE.getValue(), InputValue._BIRTHDATE.getValue(), true, compID, token_admin);
    }

    @AfterEach
    public void tearDown() throws SQLException {
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
        if (secEmpID != 0) {
            controlJDBC.deleteEmp(secEmpID);
            secEmpID = 0;
        }
        if (compID != 0) {
            controlJDBC.deleteComp(compID);
            compID = 0;
        }
        controlJDBC.close();
    }
    @Test
    @DisplayName("Получить сотрудника по ID")
    public void getEmployee() {
        given().log().all()
                .header("x-client-token", token_admin)
                .contentType(ContentType.JSON)
                .baseUri(client.URL)
                .basePath("/employee/" + empID)
                .get()
                .then().log().all()
                .statusCode(200);
    }
    @Test
    @DisplayName("Получить список сотрудников по ID")
    public void getEmployeeList() {
        given().log().all()
                .header("x-client-token", token_admin)
                .contentType(ContentType.JSON)
                .baseUri(client.URL)
                .basePath("/employee")
                .queryParam("company", compID)
                .get()
                .then().log().all()
                .statusCode(200);
    }

    @Test
    @DisplayName("Создание сотрудника")
    public void createEmployee() {
        Employee employee = new Employee(InputValue._FIRSTNAME.getValue(), InputValue._LASTNAME.getValue(),
                InputValue._MIDDLENAME.getValue(), InputValue._EMAIL.getValue(), InputValue._URL.getValue(),
                InputValue._PHONE.getValue(), InputValue._BIRTHDATE.getValue(), true, compID);

        secEmpID = given()
                .header("x-client-token", token_admin)
                .body(employee)
                .contentType(ContentType.JSON)
                .baseUri(client.URL)
                .basePath("/employee")
                .post()
                .then()
                .statusCode(201)
                .extract().jsonPath().getInt("id");

        assertTrue(secEmpID > 0);
    }

    @Test
    @DisplayName("Изменение инфо по сотруднику")
    public void changeEmployeeInfoId() {
        ChangeEmployee changeEmployee = new ChangeEmployee("a128732@mail.ru", "a1441.com", false);
        given().log().all()
                .contentType(ContentType.JSON)
                .header("x-client-token", token_admin)
                .baseUri(client.URL)
                .basePath("/employee/" + empID)
                .body(changeEmployee)
                .patch()
                .then().log().all()
                .statusCode(200);
    }

}
