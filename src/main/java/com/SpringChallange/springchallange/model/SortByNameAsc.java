package com.SpringChallange.springchallange.model;

import com.SpringChallange.springchallange.dto.ProductDTO;

import java.util.Comparator;

public class SortByNameAsc implements Comparator<ProductDTO> {
    @Override
    public int compare(ProductDTO a, ProductDTO b) {
        return a.getName().compareTo(b.getName());
    }

}
