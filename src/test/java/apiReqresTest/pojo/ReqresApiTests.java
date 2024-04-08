package apiReqresTest.pojo;

import apiReqresTest.pojo.model.*;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.*;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

public class ReqresApiTests {
    private String URL = "https://reqres.in/";

    @Test
    @DisplayName("Получить список юзеров. ID и имена аватаров совпадают, email заканчивается на reqres.in")
    @Tag("get")
    @Tag("all")
    public void getListAllUsersTest() {
        List<UserData> listAllUser = given()
                .contentType(ContentType.JSON)
                .get(URL + "api/users?page=2")
                .then().log().all()
                .statusCode(200)
                .extract()
                .body()
                .jsonPath()
                .getList("data", UserData.class);
////        V1.0
//        for (int i = 0; i < listAllUser.size(); i++){
//            assertTrue(listAllUser.get(i).avatar().contains(listAllUser.get(i).id().toString()));
//        }
////        V2.0
//        for(UserData user : listAllUser){
//            assertTrue(user.avatar().contains(user.id().toString()));
//        }
//        V3.0
        listAllUser.forEach(x -> assertTrue(x.avatar().contains(x.id().toString())));
        listAllUser.forEach(x -> assertTrue(x.email().endsWith("reqres.in")));
    }

    @Test
    @DisplayName("Успешная регистрация")
    @Tag("post")
    @Tag("create")
    @Tag("all")
    public void createUserTest() {
        UserRegReq userRegReq = new UserRegReq("eve.holt@reqres.in", "pistol");
        UserRegResp userRegResp = given()
                .contentType(ContentType.JSON)
                .body(userRegReq)
                .post(URL + "api/register")
                .then().log().all()
                .statusCode(200)
                .extract().as(UserRegResp.class);
        assertFalse(userRegResp.token().isBlank());
    }

    @Test
    @DisplayName("Регистрация без пароля")
    @Tag("post")
    @Tag("create")
    @Tag("all")
    public void badRegUserTest() {
        UserRegReq userRegReq = new UserRegReq("sydney@fife", "");
        ErrorReg errorReg = given()
                .contentType(ContentType.JSON)
                .body(userRegReq)
                .post(URL + "api/register")
                .then().log().all()
                .statusCode(400)
                .extract().as(ErrorReg.class);
        assertEquals(errorReg.error(), "Missing password");
    }

    @Test
    @DisplayName("Сортировка списка по возрастанию дат")
    public void getSortedListResourceTest() {
        List<ResourceData> resourceData = given()
                .contentType(ContentType.JSON)
                .get(URL + "api/unknown")
                .then().log().all()
                .statusCode(200)
                .extract()
                .body()
                .jsonPath().getList("data", ResourceData.class);
        List<Integer> notSortList = resourceData.stream().map(ResourceData::year).toList();
        List<Integer> sortList = notSortList.stream().sorted().toList();
        assertEquals(notSortList, sortList);
    }

    @Test
    @DisplayName("Удаление юзера")
    @Tag("all")
    @Tag("delete")
    public void deleteUserTest() {
        given()
                .contentType(ContentType.JSON)
                .delete(URL + "api/users/2")
                .then().log().all()
                .statusCode(204);
    }

    @Test
    @DisplayName("Сравнение даты изменения инфо")
    @Tag("all")
    @Tag("put")
    public void putInfoUser() {
        UserUpdate userUpdate = new UserUpdate("morpheus", "zion resident");
        LocalDateTime localDateTime = LocalDateTime.now();
        String date = given()
                .contentType(ContentType.JSON)
                .body(userUpdate)
                .put(URL + "api/users/2")
                .then().log().all()
                .extract().jsonPath().getString("updatedAt");
        String substLocalDateTime = localDateTime.minusHours(3).toString().substring(0, 16);
        assertEquals(date.substring(0, 16), substLocalDateTime);
    }
}
