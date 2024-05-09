package cl.privera.depin.application.controllers;

import cl.privera.depin.domain.abstractions.services.IProductService;
import cl.privera.depin.domain.entities.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller @Slf4j @RestController
public class ProductController {

    @Autowired
    private IProductService service;

    @GetMapping("/products")
    public List<Product> getAll() {
        log.info("ProductController: getAll");
        return service.getAll();
    }
}
