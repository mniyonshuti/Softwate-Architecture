package edu.cs.cs590.webshop.controller;

import edu.cs.cs590.webshop.model.CartDto;
import edu.cs.cs590.webshop.model.ShoppingCart;
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
    public void addToCart(@RequestBody CartDto cartDto) {
        shoppingService.addToCart(cartDto.getCartId(), cartDto.getProductnumber(), cartDto.getQuantity());
    }

    @GetMapping("/{cartId}")
    public ResponseEntity<?> getCart(@PathVariable("cartId") String cartId) {
        return new ResponseEntity<>(shoppingService.getCart(cartId), HttpStatus.OK);
    }
}
