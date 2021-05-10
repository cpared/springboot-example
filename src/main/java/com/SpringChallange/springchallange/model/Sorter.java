package com.SpringChallange.springchallange.model;

import com.SpringChallange.springchallange.dto.ProductDTO;
import com.SpringChallange.springchallange.exception.InvalidOrderCriteriaException;

import java.util.Comparator;
import java.util.HashMap;

public class Sorter {
    private final HashMap<Integer, Comparator<ProductDTO>> compCriteria = new HashMap<>();

    public Sorter() {
        this.compCriteria.put(0, new SortByNameAsc());
        this.compCriteria.put(1, new SortByNameDesc());
        this.compCriteria.put(2, new SortByPriceAsc());
        this.compCriteria.put(3, new SortByPriceDesc());
    }

    public Comparator<ProductDTO> getComparatorCriteria(Integer id) throws InvalidOrderCriteriaException {
        if(id == null) id = 0;
        try {
            return this.compCriteria.get(id);
        } catch (Exception ex) {
            throw new InvalidOrderCriteriaException("Order not found. The order number is not valid!");
        }
    }
}
