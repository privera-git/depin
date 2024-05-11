package cl.privera.depin.presentation.controllers;

import cl.privera.depin.application.abstractions.handlers.IAddProductHandler;
import cl.privera.depin.application.abstractions.handlers.IUpdateProductHandler;
import cl.privera.depin.application.dtos.AddProductDto;
import cl.privera.depin.application.dtos.ProductDto;
import cl.privera.depin.application.dtos.UpdateProductDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller @Slf4j @RestController
public class UpdateProductController {

    @Autowired
    private IUpdateProductHandler handler;

    @PutMapping("/products/{id}")
    public ProductDto add(@PathVariable int id, @RequestBody UpdateProductDto requestBody) {
        log.info("UpdateProductController: put {} {}", id, requestBody);

        return handler.handle(new ProductDto(id, requestBody.description(), requestBody.category()));
    }
}
