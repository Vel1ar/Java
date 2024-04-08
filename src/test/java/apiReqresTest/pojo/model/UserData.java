package apiReqresTest.pojo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record UserData(Integer id, String email, String first_name, String last_name, String avatar) {
}
