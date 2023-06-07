package org.example.service;

import org.example.entity.Product;
import org.example.repository.implementation.ProductRepo;

public class ProductService {
    ProductRepo productRepo;

    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public void addNewProduct(Product product) {
        productRepo.addProduct(product);
    }


    public void updateNewProduct(Product product) {
        productRepo.updateProduct(product);
    }

    public void deleteNewProduct(int productID) {
        productRepo.deleteProduct(productID);
    }
}

