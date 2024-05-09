package cl.privera.depin.infrastructure.repositories;

import cl.privera.depin.domain.abstractions.repositories.IDummyProductRepository;
import cl.privera.depin.domain.entities.Product;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository @Slf4j @AllArgsConstructor
public class DummyDummyProductRepository implements IDummyProductRepository {

    @Override
    public void add(Product product) {
        log.info("Product repository: add");
    }

    @Override
    public void delete(int id) {
        log.info("Product repository: delete");
    }

    @Override
    public List<Product> getAll() {
        log.info("Product repository: get all");
        return Arrays.asList(
            new Product(1, "product 1", "some category"),
            new Product(2, "product 2", "some category"),
            new Product(3, "product 3", "some category")
        );
    }

    @Override
    public Product getSingle(int id) {
        log.info("Product repository: get single");
        return new Product(id, "product " + id, "some category");
    }

    @Override
    public void update(Product product) {
        log.info("Product repository: update");
    }
}
