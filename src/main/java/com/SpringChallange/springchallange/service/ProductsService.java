package com.SpringChallange.springchallange.service;

import com.SpringChallange.springchallange.dto.*;
import com.SpringChallange.springchallange.exception.EmptyShoppingCartException;
import com.SpringChallange.springchallange.exception.InvalidOrderCriteriaException;
import com.SpringChallange.springchallange.exception.NotEnoughProductsException;
import com.SpringChallange.springchallange.exception.ProductNotFoundException;
import com.SpringChallange.springchallange.model.*;
import com.SpringChallange.springchallange.repository.IRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductsService implements IProductsService{
    private TicketGenerator ticketGenerator = new TicketGenerator();

    @Autowired
    IRepository repository;

    @Override
    public List<ProductDTO> getAllProducts(RequestParamsDTO reqParams) throws InvalidOrderCriteriaException {
        FilterDTO filters = DtoMapper.convertToFilterDTO(reqParams);
        List<ProductDTO> response = repository.getAllProducts();

        FilterCriteria filterCriteria = new FilterCriteria(response, filters);
        response = filterCriteria.getFilteredList();

        try{
            Sorter sorter = new Sorter();
            response.sort(sorter.getComparatorCriteria(reqParams.getOrder()));
        } catch(Exception ex){
            throw new InvalidOrderCriteriaException("Order not found. The order number is not valid!");
        }
        return response;
    }

    @Override
    public TicketResponseDTO purchaseRequest(RequestProductsDTO request) throws ProductNotFoundException, NotEnoughProductsException, EmptyShoppingCartException {
        return this.responseBuilder(request.getArticles());
    }

    @Override
    public void addToShoppingCart(ArticleDTO article) throws NotEnoughProductsException, ProductNotFoundException {
        this.repository.addToShoppingCart(article);
    }

    @Override
    public List<ProductDTO> getCartItems() {
        return this.repository.getCartItems();
    }

    @Override
    public TicketResponseDTO purchaseFromShoppingCart() throws ProductNotFoundException, NotEnoughProductsException, EmptyShoppingCartException {
        TicketResponseDTO response = this.responseBuilder(DtoMapper.convertProductToArticleDTO(this.repository.getCartItems()));
        this.repository.clearCartItems();
        return response;
    }

    private TicketResponseDTO responseBuilder(List<ArticleDTO> articles) throws EmptyShoppingCartException, ProductNotFoundException, NotEnoughProductsException {
        if(articles.isEmpty()) {
            throw new EmptyShoppingCartException("The Shopping Cart is empty");
        }
        TicketResponseDTO response = ticketGenerator.generateTicket(articles);
        response.setTotal(this.calculateTotal(articles));
        StatusCodeDTO statusResponse = new StatusCodeDTO(HttpStatus.OK, "La solicitud de compra se completó con éxito");
        response.setStatusResponse(statusResponse);
        return response;
    }

    private Integer calculateTotal(List<ArticleDTO> articles) throws ProductNotFoundException, NotEnoughProductsException {
        Integer total = 0;
        for(ArticleDTO article: articles){
            ProductDTO product = this.repository.getProductById(article.getProductId());
            if(product.getQuantity() < article.getQuantity()) {
                throw new NotEnoughProductsException("The article " + article.getName() + "have have: " + product.getQuantity() + " products in stock");
            }
            total = total + (article.getQuantity() * product.getPrice());
            this.repository.reduceProductQuantity(product.getId(), article.getQuantity());
        }
        return total;
    }
}
