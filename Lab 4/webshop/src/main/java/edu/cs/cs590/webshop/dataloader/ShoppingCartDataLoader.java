package edu.cs.cs590.webshop.dataloader;

import edu.cs.cs590.webshop.model.ShoppingCart;
import edu.cs.cs590.webshop.repository.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class ShoppingCartDataLoader implements CommandLineRunner {
    @Autowired
    ShoppingCartRepository shoppingCartRepository;

    @Override
    public void run(String... args) throws Exception {
        shoppingCartRepository.save(new ShoppingCart("123", new ArrayList<>()));
        shoppingCartRepository.save(new ShoppingCart("124", new ArrayList<>()));
        shoppingCartRepository.save(new ShoppingCart("125", new ArrayList<>()));
        shoppingCartRepository.save(new ShoppingCart("126", new ArrayList<>()));
        shoppingCartRepository.save(new ShoppingCart("127", new ArrayList<>()));
    }
}
