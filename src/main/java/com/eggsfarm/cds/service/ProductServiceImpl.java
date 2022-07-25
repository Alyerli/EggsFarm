
package com.eggsfarm.cds.service;

import com.eggsfarm.cds.dao.ProductsDao;
import com.eggsfarm.cds.domain.Products;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductsDao productsDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Products> listarProducts() {
        return (List<Products>) productsDao.findAll();
    }

    @Override
    @Transactional
    public void save(Products products) {
        productsDao.save(products);
    }

    @Override
    @Transactional
    public void delete(Products products) {
        productsDao.delete(products);
    }

    @Override
    @Transactional(readOnly = true)
    public Products findProducts(Products products) {
        return productsDao.findById(products.getIdProducts()).orElse(null);
    }
    
}
