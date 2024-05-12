package cl.privera.depin.presentation.controllers;

import cl.privera.depin.application.abstractions.handlers.IGetProductHandler;
import cl.privera.depin.application.dtos.ProductDto;
import cl.privera.depin.presentation.exceptions.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Controller @Slf4j @RestController
public class GetProductController {

    @Autowired
    private IGetProductHandler getProductHandler;

    @GetMapping("/products/{id}")
    public ResponseEntity<ProductDto> getSingle(@PathVariable Integer id) {
        log.info("ProductController: get {}", id);
        var dto = getProductHandler.handle(id);
        if (dto == null) {
            ResponseEntity.notFound();
        }

        return ResponseEntity.ok(dto);
    }
}
