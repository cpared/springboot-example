package com.SpringChallange.springchallange.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class RequestParamsDTO {
    private String category;
    private String brand;
    private Boolean isFreeShipping;
    private Integer points;
    private Integer order;

    @Override
    public String toString() {
        return "RequestParamsDTO{" +
                "category='" + category + '\'' +
                ", brand='" + brand + '\'' +
                ", isFreeShipping=" + isFreeShipping +
                ", points=" + points +
                ", order=" + order +
                '}';
    }
}
