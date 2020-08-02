package cs590.order.web;

import cs590.order.service.OrderDTO;
import cs590.order.service.OrderService;
import cs590.order.service.ShoppingCartDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {
	@Autowired
	OrderService orderService;
	
	
	@GetMapping("/order/{orderNumber}")
	public ResponseEntity<?> getCart(@PathVariable String orderNumber) {
		OrderDTO orderDTO  = orderService.getOrder(orderNumber);
		return new ResponseEntity<OrderDTO>(orderDTO, HttpStatus.OK);
	}
	
	@PostMapping("/order/{orderNumber}")
	public void confirm(@PathVariable String orderNumber) {
		orderService.confirm(orderNumber);
	}
	
	@PostMapping("/order/setCustomer/{orderNumber}/{customerNumber}")
	public ResponseEntity<?> SetCustomer(@PathVariable String orderNumber, @PathVariable String customerNumber) {
		orderService.setCustomer(orderNumber,customerNumber);
		OrderDTO orderDTO  = orderService.getOrder(orderNumber);
		return new ResponseEntity<OrderDTO>(orderDTO, HttpStatus.OK);
	}

	@PostMapping("/order/createorder")
	public void create(@RequestBody ShoppingCartDTO shoppingCartDTO) {
		orderService.createOrder(shoppingCartDTO);
	}
}
