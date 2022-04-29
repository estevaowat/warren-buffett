package com.ewcode.warrenbufett.dtos.user;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Objects;

public class UserSaveDto {

    @NotNull
    private String name;

    @NotNull
    @Email(message = "should be a valid e-mail")
    private String email;

    public String getName() {
        return name;
    }

    public UserSaveDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserSaveDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public UserSaveDto(String name, String email) {
        this.name = name;
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;

        UserSaveDto that = (UserSaveDto) o;

        if(!Objects.equals(name, that.name)) return false;
        return Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserSaveDto{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public String toJson() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(this);
    }
}
