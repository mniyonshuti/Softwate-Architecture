package edu.cs.cs590.webshop.repository;

import edu.cs.cs590.webshop.model.ShoppingCart;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ShoppingCartRepository extends MongoRepository<ShoppingCart, String> {
}
