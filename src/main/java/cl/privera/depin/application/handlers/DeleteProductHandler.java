package cl.privera.depin.application.handlers;

import cl.privera.depin.application.abstractions.handlers.IDeleteProductHandler;
import cl.privera.depin.application.abstractions.mappers.IProductMapper;
import cl.privera.depin.domain.abstractions.services.IProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class DeleteProductHandler implements IDeleteProductHandler {

    @Autowired
    private IProductService service;

    @Autowired
    private IProductMapper mapper;

    public boolean handle(int id) {
        log.info("DeleteProductHandler: handle");

        var entity = service.getSingle(id);
        if (entity == null) {
            log.info("Product not found");
            return false;
        }

        service.delete(id);
        return true;
    }
}
