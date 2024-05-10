package cl.privera.depin.presentation.controllers;

import cl.privera.depin.application.abstractions.handlers.IAddProductHandler;
import cl.privera.depin.application.abstractions.handlers.IGetProductHandler;
import cl.privera.depin.application.dtos.AddProductDto;
import cl.privera.depin.application.dtos.ProductDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller @Slf4j @RestController
public class AddProductController {

    @Autowired
    private IAddProductHandler handler;

    @PostMapping("/products")
    public ProductDto add(@RequestBody AddProductDto request) {
        log.info("AddProductController: post {}", request);
        return handler.handle(request);
    }
}
