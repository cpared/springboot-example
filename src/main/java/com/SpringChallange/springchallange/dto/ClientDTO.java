package com.SpringChallange.springchallange.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

@Getter
@Setter
public class ClientDTO {
    private String firstName;
    private String lastName;
    private Integer dni;
    private String direction;
    private String provincia;

    @Override
    public String toString() {
        return "ClientDTO{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dni=" + dni +
                ", direction='" + direction + '\'' +
                ", provincia='" + provincia + '\'' +
                '}';
    }
}
