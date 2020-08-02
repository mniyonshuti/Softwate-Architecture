package cs590.shopping.repository;

import cs590.shopping.domain.ShoppingCart;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ShoppingCartRepository extends MongoRepository<ShoppingCart, String> {

}
