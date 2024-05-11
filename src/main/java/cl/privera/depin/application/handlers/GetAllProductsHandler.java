package cl.privera.depin.application.handlers;

import cl.privera.depin.application.abstractions.handlers.IGetAllProductsHandler;
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
public class GetAllProductsHandler implements IGetAllProductsHandler {

    @Autowired
    private IProductService service;

    @Autowired
    private IProductMapper mapper;

    @Autowired @Qualifier("fancy")
    private IProductWriter writer;

    public Iterable<ProductDto> handle() {
        log.info("GetAllProductsHandler: handle");

        var entities = service.getAll();

        return mapper.map(entities);
    }
}
