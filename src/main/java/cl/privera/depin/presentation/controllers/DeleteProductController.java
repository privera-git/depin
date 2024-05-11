package cl.privera.depin.presentation.controllers;

import cl.privera.depin.application.abstractions.handlers.IDeleteProductHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Controller @Slf4j @RestController
public class DeleteProductController {

    @Autowired
    private IDeleteProductHandler handler;

    @DeleteMapping("/products/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        log.info("ProductController: get {}", id);
        if (handler.handle(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
