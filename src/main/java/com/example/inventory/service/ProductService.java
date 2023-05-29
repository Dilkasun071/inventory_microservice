package com.example.inventory.service;

import com.example.inventory.dto.Item;
import com.example.inventory.entity.Product;
import com.example.inventory.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Product addProduct(Item item){
        Product product = new Product();
        product.setProductName(item.getProductName());
        product.setPrice(Double.valueOf(item.getPrice()));
        product.setQty(Integer.valueOf(item.getQuantity()));
        return  productRepository.save(product);
    }

    public Product findById(Long id){
        return productRepository.findById(id).get();
    }

}
