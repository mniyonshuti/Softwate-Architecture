package edu.cs.cs590.webshop.service;

import edu.cs.cs590.webshop.model.Product;
import edu.cs.cs590.webshop.model.Stock;
import edu.cs.cs590.webshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductCatalogService {
    @Autowired
    ProductRepository productRepository;

    public void addProduct(Product product){
        productRepository.save(product);
    }

    public Product getProduct(String productNumber){
        Optional<Product> optional = productRepository.findById(productNumber);
        if(optional.isPresent()) return optional.get();
        return null;
    }

    public void setStock(String productNumber, int quantity, String locationCode){
        Optional<Product> optional = productRepository.findById(productNumber);
        if(optional.isPresent()){
            Product product = optional.get();
            Stock stock = product.getStock();
            if(stock == null) stock = new Stock();
            stock.setNrInStock(quantity);
            stock.setLocationCode(locationCode);
            product.setStock(stock);
            productRepository.save(product);
        }
    }

}
