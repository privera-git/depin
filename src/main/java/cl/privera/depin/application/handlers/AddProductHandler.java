package cl.privera.depin.application.handlers;

import cl.privera.depin.application.abstractions.handlers.IAddProductHandler;
import cl.privera.depin.application.abstractions.mappers.IProductMapper;
import cl.privera.depin.application.dtos.AddProductDto;
import cl.privera.depin.application.dtos.ProductDto;
import cl.privera.depin.domain.abstractions.services.IProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class AddProductHandler implements IAddProductHandler {

    @Autowired
    private IProductService service;

    @Autowired
    private IProductMapper mapper;

    public ProductDto handle(AddProductDto request) {
        log.info("AddProductHandler: handle");
        var entity = mapper.map(request);
        service.add(entity);

        return mapper.map(entity);
    }
}
