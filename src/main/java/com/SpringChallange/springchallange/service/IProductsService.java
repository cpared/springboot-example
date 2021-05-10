package com.SpringChallange.springchallange.service;

import com.SpringChallange.springchallange.dto.*;
import com.SpringChallange.springchallange.exception.EmptyShoppingCartException;
import com.SpringChallange.springchallange.exception.InvalidOrderCriteriaException;
import com.SpringChallange.springchallange.exception.NotEnoughProductsException;
import com.SpringChallange.springchallange.exception.ProductNotFoundException;

import java.util.*;

public interface IProductsService {

    List<ProductDTO> getAllProducts(RequestParamsDTO reqParams) throws InvalidOrderCriteriaException;
    TicketResponseDTO purchaseRequest(RequestProductsDTO request) throws ProductNotFoundException, NotEnoughProductsException, EmptyShoppingCartException;
    void addToShoppingCart(ArticleDTO article) throws NotEnoughProductsException, ProductNotFoundException;
    List<ProductDTO> getCartItems();
    TicketResponseDTO purchaseFromShoppingCart() throws ProductNotFoundException, NotEnoughProductsException, EmptyShoppingCartException;
}
