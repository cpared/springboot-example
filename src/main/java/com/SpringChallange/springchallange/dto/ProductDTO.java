package com.SpringChallange.springchallange.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO{

    private Integer id;
    private String name;
    private String category;
    private String brand;
    private Integer price;
    private Integer quantity;
    private Boolean isFreeShipping;
    private Integer points;

    @Override
    public String toString() {
        return "ProductDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", isFreeShipping=" + isFreeShipping +
                ", points=" + points +
                '}';
    }
}
