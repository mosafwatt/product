package com.example.ProductREST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController // to tell spring framework that this controller we handle requests
public class Controller {

    @Autowired //instant product injected
    private ProductService service;

    @GetMapping("/products") // to handle the HTTP GET request
    public List<Product> list(){

        return service.listAll();
    } // list all products method

    @GetMapping("/products/{id}")
    //@pathvariable to handle template variable in URL mapping
    public ResponseEntity<Product> get(@PathVariable Integer id) {
        try {
            Product product = service.get(id);
            return new ResponseEntity<Product>(product, HttpStatus.OK);
        } catch(NoSuchElementException e){
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/products")
    public void add(@RequestBody Product product){
        service.save(product);
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Object> update(@RequestBody Product product, @PathVariable Integer id){
        try {
            Product existProduct = service.get(id);
            service.save(product);

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/products/{id}")
    public void delete(@PathVariable Integer id){
        service.delete(id);
    }


}

