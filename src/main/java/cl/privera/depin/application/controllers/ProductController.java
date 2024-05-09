package cl.privera.depin.application.controllers;

import cl.privera.depin.domain.abstractions.services.IProductService;
import cl.privera.depin.domain.entities.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Controller @Slf4j @RestController
public class ProductController {

    @Autowired
    private IProductService service;

    @GetMapping("/products")
    public Iterable<Product> getAll() {
        log.info("ProductController: getAll");
        return service.getAll();
    }

    @GetMapping("/products/{id}")
    public Product getSingle(@PathVariable Integer id) {
        log.info("ProductController: get {}", id);
        var product = service.getSingle(id);
        log.info("product: {}", product);

        return product;
    }
}
