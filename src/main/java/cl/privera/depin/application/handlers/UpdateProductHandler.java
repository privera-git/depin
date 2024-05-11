package cl.privera.depin.application.handlers;

import cl.privera.depin.application.abstractions.handlers.IAddProductHandler;
import cl.privera.depin.application.abstractions.handlers.IUpdateProductHandler;
import cl.privera.depin.application.dtos.AddProductDto;
import cl.privera.depin.application.dtos.ProductDto;
import cl.privera.depin.application.writers.IProductWriter;
import cl.privera.depin.domain.abstractions.services.IProductService;
import cl.privera.depin.domain.entities.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UpdateProductHandler implements IUpdateProductHandler {

    @Autowired
    private IProductService service;

    public ProductDto handle(ProductDto request) {
        log.info("UpdateProductHandler: handle");

        var entity = new Product();
        entity.setId(request.id());
        entity.setDescription(request.description());
        entity.setCategory(request.category());

        service.update(entity);

        return new ProductDto(entity.getId(), entity.getDescription(), entity.getCategory());
    }
}
