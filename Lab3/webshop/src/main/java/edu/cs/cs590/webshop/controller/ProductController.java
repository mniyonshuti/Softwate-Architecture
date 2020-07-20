package edu.cs.cs590.webshop.controller;

import edu.cs.cs590.webshop.model.Product;
import edu.cs.cs590.webshop.model.StockDto;
import edu.cs.cs590.webshop.service.ProductCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductCatalogService productCatalogService;

    @PostMapping
    public void addProduct(@RequestBody Product product) {
        productCatalogService.addProduct(product);
    }

    @GetMapping("/{productnumber}")
    public ResponseEntity<?> getProduct(@PathVariable("productnumber") String productnumber) {
        return new ResponseEntity<>(productCatalogService.getProduct(productnumber), HttpStatus.OK);
    }

    @PostMapping("/updatestock")
    public void setStock(@RequestBody StockDto stockDto) {
        productCatalogService.setStock(stockDto.getProductnumber(), stockDto.getNrInStock(), stockDto.getLocationCode());
    }
}
