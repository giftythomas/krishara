package com.freestyle.service;

import java.util.List;

import com.freestyle.model.Product;

public interface ProductService {

   public void addProduct(Product product);
   
   public List<Product> viewProduct();
   
   public void deleteProduct(int id);
   
   public Product getId(int id);
   
   public void updateProduct(Product product);
}
