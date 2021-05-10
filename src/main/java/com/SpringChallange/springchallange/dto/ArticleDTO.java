package com.SpringChallange.springchallange.dto;


import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ArticleDTO {
    private Integer productId;
    private String name;
    private String brand;
    private Integer quantity;

    @Override
    public String toString() {
        return "ArticlesDTO{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
