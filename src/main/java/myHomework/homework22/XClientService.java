package myHomework.homework22;

import io.restassured.http.ContentType;
import myHomework.homework22.model.ChangeEmployee;
import myHomework.homework22.model.Employee;
import myHomework.homework22.model.Token;

import java.util.*;

import static io.restassured.RestAssured.given;

public class XClientService {

    public final String URL = "https://x-clients-be.onrender.com";

    public String getToken(String log, String pass) {

        Token token = new Token(log, pass);

        return given()
                .body(token)
                .contentType(ContentType.JSON)
                .baseUri(URL)
                .basePath("/auth/login")
                .post()
                .then()
                .extract().path("userToken");
    }

    public Integer createEmployee(String firstName, String lastName, String middleName, String mail,
                                  String url, String phone, String birthdate, Boolean isActive, Integer companyId, String token) {

        Employee employee = new Employee(firstName, lastName, middleName, mail, url, phone, birthdate,
                isActive, companyId);

        return given()
                .header("x-client-token", token)
                .body(employee)
                .contentType(ContentType.JSON)
                .baseUri(URL)
                .basePath("/employee")
                .post()
                .then()
                .extract().jsonPath().getInt("id");
    }

    public Employee getInfoEmployee(Integer id) {
        return given()
                .contentType(ContentType.JSON)
                .baseUri(URL)
                .basePath("/employee/" + id)
                .get()
                .then()
                .extract().as(Employee.class);
    }

    public List<Employee> getEmployeeListForCompany(Integer id) {
        return given()
                .contentType(ContentType.JSON)
                .baseUri(URL)
                .basePath("/employee")
                .queryParam("company", id)
                .get()
                .then()
                .extract().body().jsonPath().getList("$", Employee.class);
    }

    public Employee changeEmployeeInfoId(Integer id, String lastName, String email, String url, String phone,
                                           Boolean isActive, String token) {
        ChangeEmployee changeEmployee = new ChangeEmployee(lastName, email, url, phone, isActive);
        return given()
                .contentType(ContentType.JSON)
                .header("x-client-token", token)
                .baseUri(URL)
                .basePath("/employee/" + id)
                .body(changeEmployee)
                .patch()
                .then()
                .extract().body().as(Employee.class);
    }
}