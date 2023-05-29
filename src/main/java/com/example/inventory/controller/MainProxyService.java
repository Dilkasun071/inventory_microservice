package com.example.inventory.controller;

import com.example.inventory.dto.Item;
import com.example.inventory.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MainProxyService {

    @Autowired
    private ProductService productService;

    @GetMapping("/inventory/test")
	public ResponseEntity<?> test(){
        return new ResponseEntity<>("Test!!", HttpStatus.OK);
    }

    @GetMapping("/inventory/getAllProducts")
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/inventory/addProduct")
    public ResponseEntity<?> addProduct(@RequestBody Item item){
        return new ResponseEntity<>(productService.addProduct(item), HttpStatus.OK);
    }

    @GetMapping("/inventory/findById/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long id){
        return new ResponseEntity<>(productService.findById(id), HttpStatus.OK);
    }


}
