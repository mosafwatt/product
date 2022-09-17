package com.example.ProductREST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ProductService {
    @Autowired //injection of the product repository instant
    private ProductRepository repo;  //instance for product repo

    public List<Product> listAll(){
        return repo.findAll();
    }
    public void save(Product product){
        repo.save(product);
    }
    public Product get(Integer id){
        return repo.findById(id).get();
        // get product based on id
    }
    public void delete(Integer id){
        repo.deleteById(id);
    }
}
