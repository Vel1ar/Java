package myHomework.homework22.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Employee(String firstName, String lastName, String middleName,
                       String url, String phone, String birthdate, Boolean isActive, Integer companyId) {
}
