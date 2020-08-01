package edu.cs.cs590.webshop.service;

import edu.cs.cs590.webshop.model.*;
import edu.cs.cs590.webshop.repository.OrderRepository;
import edu.cs.cs590.webshop.repository.ProductRepository;
import edu.cs.cs590.webshop.repository.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShoppingService {
    @Autowired
    ShoppingCartRepository shoppingCartRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    OrderService orderService;

    public void addToCart(String cartId, String productNumber, int quantity) {
        Optional<ShoppingCart> optional = shoppingCartRepository.findById(cartId);
        if (optional.isPresent()) {
            ShoppingCart shoppingCart = optional.get();
            Optional<Product> productOptional = productRepository.findById(productNumber);
            CartLine cartLine = new CartLine();
            if (productOptional.isPresent()) {
                Product product = productOptional.get();
                cartLine.setQuantity(quantity);
                cartLine.setProduct(product);
            }
            shoppingCart.getCartLines().add(cartLine);
            shoppingCartRepository.save(shoppingCart);
        }
    }

    public ShoppingCart getCart(String cartId) {
        Optional<ShoppingCart> shoppingCart = shoppingCartRepository.findById(cartId);
        if (shoppingCart.isPresent()) return shoppingCart.get();
        return null;
    }

    public void checkOut(String cartId) {
        Optional<ShoppingCart> shoppingCart = shoppingCartRepository.findById(cartId);
        if(shoppingCart.get() != null) orderService.createOrder(shoppingCart.get());
    }
}
