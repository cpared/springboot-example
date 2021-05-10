package com.SpringChallange.springchallange.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

@Getter @Setter
public class FilterDTO {
    private String category;
    private String brand;
    private Boolean isFreeShipping;
    private Integer points;

    @Override
    public String toString() {
        return "FilterDTO{" +
                "category='" + category + '\'' +
                ", brand='" + brand + '\'' +
                ", isFreeShipping=" + isFreeShipping +
                ", points=" + points +
                '}';
    }
}
