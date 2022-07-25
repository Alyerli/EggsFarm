package com.eggsfarm.cds.dao;

import com.eggsfarm.cds.domain.Products;
import org.springframework.data.repository.CrudRepository;


public interface ProductsDao extends CrudRepository<Products, Long>{
    
}
