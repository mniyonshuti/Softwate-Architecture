package edu.cs.cs590.webshop.service;

import edu.cs.cs590.webshop.model.Order;
import edu.cs.cs590.webshop.model.OrderLine;
import edu.cs.cs590.webshop.model.ShoppingCart;
import edu.cs.cs590.webshop.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public void createOrder(ShoppingCart shoppingCart){
        Order order = new Order();
        order.setOrderNumber(shoppingCart.getCartId());
        List<OrderLine> orderLineList = new ArrayList<>();
        shoppingCart.getCartLines().stream().map(cartLine -> (
                orderLineList.add(new OrderLine(cartLine.getQuantity(), cartLine.getProduct()))
        ));
        order.setOrderLineList(orderLineList);
        order.setDate(LocalDate.now());
        order.setOrderStatus(true);
        orderRepository.save(order);
    }

    public Order getOrder(String orderId){
        Optional<Order> order = orderRepository.findById(orderId);
        if(order.get() != null) return order.get();
        return null;
    }
}
