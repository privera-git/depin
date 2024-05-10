package cl.privera.depin.application.writers;

import cl.privera.depin.domain.entities.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component("fancy") @Slf4j
public class FancyProductWriter implements IProductWriter {

    @Override
    public void write(Product product) {
        log.info(System.lineSeparator() +
                "================================" + System.lineSeparator() +
                "Product" + System.lineSeparator() +
                "================================" + System.lineSeparator() +
                "Id         : " + product.getId() + System.lineSeparator() +
                "Description: " + product.getDescription() + System.lineSeparator() +
                "Category   : " + product.getCategory() + System.lineSeparator());
    }
}
