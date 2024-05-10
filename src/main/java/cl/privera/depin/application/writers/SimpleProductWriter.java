package cl.privera.depin.application.writers;

import cl.privera.depin.domain.entities.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component("simple") @Slf4j
public class SimpleProductWriter implements IProductWriter {

    @Override
    public void write(Product product) {
        log.info(String.format(
                "Product id: %d, description: %s, category: %s",
                product.getId(), product.getDescription(), product.getCategory()));
    }
}
