package com.SpringChallange.springchallange.model;

import com.SpringChallange.springchallange.dto.ProductDTO;

import java.util.Comparator;

public class SortByNameDesc implements Comparator<ProductDTO> {

    @Override
    public int compare(ProductDTO a, ProductDTO b) {
        return b.getName().compareTo(a.getName());
    }
}
