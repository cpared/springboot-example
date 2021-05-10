package com.SpringChallange.springchallange.repository;

import com.SpringChallange.springchallange.dto.ArticleDTO;
import com.SpringChallange.springchallange.dto.ProductDTO;
import com.SpringChallange.springchallange.exception.ProductNotFoundException;
import com.SpringChallange.springchallange.exception.InternalServerException;
import com.SpringChallange.springchallange.model.DtoMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.nio.file.Paths;
import java.util.*;

@Repository
public class JsonRepository implements IRepository{
    private static final String FILEPATH = "classpath:products.json";
    private List<ProductDTO> cartItems = new ArrayList<>();
    private HashMap<Integer, ProductDTO> products = new HashMap<>();

    public JsonRepository() throws InternalServerException {
        loadDataBase();
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        List<ProductDTO> products = new ArrayList<>(this.products.values());
        return products;
    }

    @Override
    public ProductDTO getProductById(Integer id) throws ProductNotFoundException {
        if(this.products.get(id) == null) throw new ProductNotFoundException("Product not found");
        return this.products.get(id);
    }

    @Override
    public void reduceProductQuantity(Integer id, Integer amount){
        this.products.get(id).setQuantity(this.products.get(id).getQuantity() - amount);
    }

    @Override
    public void addToShoppingCart(ArticleDTO article) throws ProductNotFoundException {
        if(findCartItemById(article.getProductId()) != null) {
            ProductDTO fetchedArticle = findCartItemById(article.getProductId());
            fetchedArticle.setQuantity(fetchedArticle.getQuantity() + article.getQuantity());
            fetchedArticle.setPrice(this.getProductById(fetchedArticle.getId()).getPrice() * fetchedArticle.getQuantity());
            return;
        }
        this.cartItems.add(DtoMapper.articleToProductDTO(article, getProductById(article.getProductId())));
    }

    @Override
    public List<ProductDTO> getCartItems(){
        return this.cartItems;
    }

    @Override
    public void clearCartItems() {
        this.cartItems.clear();
    }

    private ProductDTO findCartItemById(Integer id){
        for(ProductDTO product: this.cartItems) {
            if(product.getId().equals(id)) return product;
        }
        return null;
    }

    private void loadDataBase() throws InternalServerException {
        List<ProductDTO> products;
        try {
            ObjectMapper mapper = new ObjectMapper();

            products = mapper.readValue(ResourceUtils.getFile(FILEPATH), new TypeReference<>() {});

            for(ProductDTO product: products) {
                this.products.put(product.getId(), product);
            }

        } catch (Exception ex) {
            throw  new InternalServerException("Internal Server Error");
        }
    }
}
