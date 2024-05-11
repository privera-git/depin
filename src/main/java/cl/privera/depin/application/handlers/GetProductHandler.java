package cl.privera.depin.application.handlers;

import cl.privera.depin.application.abstractions.handlers.IGetProductHandler;
import cl.privera.depin.application.abstractions.mappers.IProductMapper;
import cl.privera.depin.application.dtos.ProductDto;
import cl.privera.depin.domain.abstractions.services.IProductService;
import cl.privera.depin.application.writers.IProductWriter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class GetProductHandler implements IGetProductHandler {

    @Autowired
    private IProductService service;

    @Autowired
    private IProductMapper mapper;

    @Autowired @Qualifier("fancy")
    private IProductWriter writer;

    public ProductDto handle(int id) {
        log.info("GetProductHandler: handle");

        var entity = service.getSingle(id);
        if (entity == null) {
            log.info("Product not found");
            return null;
        }

        writer.write(entity);
        return mapper.map(entity);
    }
}
