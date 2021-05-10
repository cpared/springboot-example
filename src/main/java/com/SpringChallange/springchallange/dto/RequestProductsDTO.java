package com.SpringChallange.springchallange.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class RequestProductsDTO {
    private List<ArticleDTO> articles;
}
