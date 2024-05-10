package cl.privera.depin.application.handlers;

import cl.privera.depin.application.abstractions.handlers.IGetAllProductsHandler;
import cl.privera.depin.application.dtos.ProductDto;
import cl.privera.depin.domain.abstractions.services.IProductService;
import cl.privera.depin.domain.entities.Product;
import cl.privera.depin.application.writers.IProductWriter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Slf4j
public class GetAllProductsHandler implements IGetAllProductsHandler {

    @Autowired
    private IProductService service;

    @Autowired @Qualifier("fancy")
    private IProductWriter writer;

    public Iterable<ProductDto> handle() {
        log.info("GetAllProductsHandler: handle");

        var entities = service.getAll();

        var products = new ArrayList<ProductDto>();
        entities.forEach(e -> products.add(new ProductDto(e.getId(), e.getDescription(), e.getCategory())));

        return products;
    }
}
