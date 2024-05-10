package cl.privera.depin.presentation.controllers;

import cl.privera.depin.application.abstractions.handlers.IGetAllProductsHandler;
import cl.privera.depin.application.dtos.ProductDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller @Slf4j @RestController
public class GetAllProductsController {

    @Autowired
    private IGetAllProductsHandler getAllProductsHandler;

    @GetMapping("/products")
    public Iterable<ProductDto> getAll() {
        log.info("ProductController: getAll");
        return getAllProductsHandler.handle();
    }
}
