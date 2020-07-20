package edu.cs.cs590.webshop.controller;

import edu.cs.cs590.webshop.model.Order;
import edu.cs.cs590.webshop.model.ShoppingCart;
import edu.cs.cs590.webshop.service.OrderService;
import edu.cs.cs590.webshop.service.ShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    ShoppingService shoppingService;

    @PostMapping("/create")
    public void createOrder(@RequestBody String cartId) {
        shoppingService.checkOut(cartId);
    }

    @PostMapping
    public void createOrder(@RequestBody ShoppingCart shoppingCart) {
        orderService.createOrder(shoppingCart);
    }

    @GetMapping("/{orderId}")
    public Order getOrder(@PathVariable("orderId") String orderId) {
        return orderService.getOrder(orderId);
    }
}
