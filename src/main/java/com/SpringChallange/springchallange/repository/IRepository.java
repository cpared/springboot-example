package com.SpringChallange.springchallange.repository;

import com.SpringChallange.springchallange.dto.ArticleDTO;
import com.SpringChallange.springchallange.exception.NotEnoughProductsException;
import com.SpringChallange.springchallange.exception.ProductNotFoundException;
import com.SpringChallange.springchallange.dto.ProductDTO;

import java.util.List;

public interface IRepository {

    List<ProductDTO> getAllProducts();
    ProductDTO getProductById(Integer id) throws ProductNotFoundException;
    void reduceProductQuantity(Integer id, Integer amount);
    void addToShoppingCart(ArticleDTO article) throws NotEnoughProductsException, ProductNotFoundException;
    List<ProductDTO> getCartItems();
    void clearCartItems();
}
