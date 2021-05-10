package com.SpringChallange.springchallange.controller;


import com.SpringChallange.springchallange.dto.*;
import com.SpringChallange.springchallange.exception.*;
import com.SpringChallange.springchallange.service.IProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductsController {

    @Autowired
    IProductsService service;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path="/api/v1/articles")
    public List<ProductDTO> getAllProducts(RequestParamsDTO allParams) throws InvalidOrderCriteriaException {
        return service.getAllProducts(allParams);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping(path="/api/v1/purchase-request")
    public ResponseEntity<TicketResponseDTO> purchaseRequest(@RequestBody RequestProductsDTO request) throws ProductNotFoundException, NotEnoughProductsException, EmptyShoppingCartException {
        return ResponseEntity.ok(this.service.purchaseRequest(request));
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping(path="/api/v1/shopping-cart")
    public void addToShoppingCart(@RequestBody ArticleDTO article) throws NotEnoughProductsException, ProductNotFoundException {
        this.service.addToShoppingCart(article);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping(path="/api/v1/purchase-shopping-cart")
    public ResponseEntity<TicketResponseDTO> purchaseShoppingCart() throws NotEnoughProductsException, ProductNotFoundException, EmptyShoppingCartException {
        return ResponseEntity.ok(this.service.purchaseFromShoppingCart());
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path="/api/v1/get-cart")
    public List<ProductDTO> getShoppingCart() {
        return this.service.getCartItems();
    }

}
