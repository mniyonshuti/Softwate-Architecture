package edu.cs.cs590.webshop.controller;

import edu.cs.cs590.webshop.model.ProductDto;
import edu.cs.cs590.webshop.service.ShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shoppingcart")
public class ShoppingCartController {
    @Autowired
    ShoppingService shoppingService;

    @PostMapping
    public void addToCart(@RequestBody ProductDto productDto) {
        shoppingService.addToCart(productDto.getCartId(), productDto.getProductNumber(), productDto.getQuantity());
    }

    @GetMapping("/{cartId}")
    public ResponseEntity<?> getCart(@PathVariable("cartId") String cartId) {
        return new ResponseEntity<>(shoppingService.getCart(cartId), HttpStatus.OK);
    }
}
