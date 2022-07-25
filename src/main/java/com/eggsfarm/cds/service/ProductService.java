package com.eggsfarm.cds.service;

import com.eggsfarm.cds.domain.Products;
import java.util.List;

public interface ProductService {
    
    public List<Products> listarProducts();
    
    public void save(Products products);
    
    public void delete(Products products);
    
    public Products findProducts(Products products);
}
