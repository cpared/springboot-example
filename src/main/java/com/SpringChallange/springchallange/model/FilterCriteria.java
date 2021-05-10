package com.SpringChallange.springchallange.model;


import com.SpringChallange.springchallange.dto.FilterDTO;
import com.SpringChallange.springchallange.dto.ProductDTO;

import java.util.List;
import java.util.stream.Collectors;

public class FilterCriteria {

    private List<ProductDTO> filteredList;
    private FilterDTO filters;

    public FilterCriteria(List<ProductDTO> filteredList, FilterDTO filters) {
        this.filteredList = filteredList;
        this.filters = filters;
    }

    public List<ProductDTO> getFilteredList(){
        this.filterByCategory(this.filters.getCategory());
        this.filterByBrand(this.filters.getBrand());
        this.filterByPoints(this.filters.getPoints());
        if(this.filters.getIsFreeShipping() != null) this.filterByFreeShipping(this.filters.getIsFreeShipping());
        return this.filteredList;
    }

    public void filterByCategory(String category){
        if(category == null) return;
        filteredList = filteredList
                    .stream()
                    .filter(product -> product.getCategory().equalsIgnoreCase(category))
                    .collect(Collectors.toList());
    }

    public void filterByBrand(String brand){
        if(brand == null) return;
        filteredList = filteredList
                .stream()
                .filter(product -> product.getBrand().equalsIgnoreCase(brand))
                .collect(Collectors.toList());
    }

    public void filterByPoints(Integer points){
        if(points == null) return;
        filteredList = filteredList
                .stream()
                .filter(product -> product.getPoints() >= points)
                .collect(Collectors.toList());
    }

    public void filterByFreeShipping(boolean isFreeShipping){
        filteredList = filteredList
                .stream()
                .filter(product -> product.getIsFreeShipping() == isFreeShipping)
                .collect(Collectors.toList());
    }

}
