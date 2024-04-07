package myHomework.homework22;

import io.restassured.http.ContentType;
import myHomework.homework22.model.Employee;
import myHomework.homework22.model.Token;

import java.util.*;

import static io.restassured.RestAssured.given;

public class XClientService {

    public final String URL = "https://x-clients-be.onrender.com";

    public String getToken(String log, String pass) {

        Token token = new Token(log, pass);

        return given().log().all()
                .body(token)
                .contentType(ContentType.JSON)
                .baseUri(URL)
                .basePath("/auth/login")
                .post()
                .then().log().all()
                .extract().path("userToken");
    }

    public Integer createEmployee(String firstName, String lastName, String middleName, Integer companyId,
                                  String url, String phone, String birthdate, Boolean isActive, String token) {

        Employee employee = new Employee(firstName, lastName, middleName, url, phone, birthdate,
                isActive, companyId);

        return given().log().all()
                .header("x-client-token", token)
                .body(employee)
                .contentType(ContentType.JSON)
                .baseUri(URL)
                .basePath("/employee")
                .post()
                .then().log().all()
                .extract().jsonPath().getInt("id");
    }

    public Employee getInfoEmployee(Integer id) {
        return given().log().all()
                .contentType(ContentType.JSON)
                .baseUri(URL)
                .basePath("/employee/" + id)
                .get()
                .then().log().all()
                .extract().as(Employee.class);
    }

    public List<Employee> getEmployeeListForCompany(Integer id) {
        return given().log().all()
                .contentType(ContentType.JSON)
                .baseUri(URL)
                .basePath("/employee")
                .queryParam("company", id)
                .get()
                .then().log().all()
                .extract().body().jsonPath().getList("$", Employee.class);
    }
}