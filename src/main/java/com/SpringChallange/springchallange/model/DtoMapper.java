package com.SpringChallange.springchallange.model;

import com.SpringChallange.springchallange.dto.ArticleDTO;
import com.SpringChallange.springchallange.dto.FilterDTO;
import com.SpringChallange.springchallange.dto.ProductDTO;
import com.SpringChallange.springchallange.dto.RequestParamsDTO;
import com.SpringChallange.springchallange.exception.ProductNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class DtoMapper {

    public static ProductDTO articleToProductDTO(ArticleDTO article, ProductDTO fetchedProduct) throws ProductNotFoundException {
        ProductDTO product = new ProductDTO();
        product.setId(fetchedProduct.getId());
        product.setName(fetchedProduct.getName());
        product.setCategory(fetchedProduct.getCategory());
        product.setBrand(fetchedProduct.getBrand());
        product.setQuantity(article.getQuantity());
        product.setPrice(fetchedProduct.getPrice());
        product.setIsFreeShipping(fetchedProduct.getIsFreeShipping());
        product.setPoints(fetchedProduct.getPoints());
        product.setPrice(article.getQuantity() * fetchedProduct.getPrice());
        return product;
    }

    public static List<ArticleDTO> convertProductToArticleDTO(List<ProductDTO> products){
        List<ArticleDTO> articles = new ArrayList<>();
        for(ProductDTO product: products) {
            ArticleDTO article = new ArticleDTO();
            article.setQuantity(product.getQuantity());
            article.setName(product.getName());
            article.setBrand(product.getBrand());
            article.setProductId(product.getId());
            articles.add(article);
        }
        return articles;
    }

    public static FilterDTO convertToFilterDTO(RequestParamsDTO reqParams){
        FilterDTO filter = new FilterDTO();
        filter.setBrand(reqParams.getBrand());
        filter.setCategory(reqParams.getCategory());
        filter.setPoints(reqParams.getPoints());
        if(reqParams.getIsFreeShipping() != null) filter.setIsFreeShipping(reqParams.getIsFreeShipping());
        return filter;
    }
}
