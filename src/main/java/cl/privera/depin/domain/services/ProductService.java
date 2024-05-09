package cl.privera.depin.domain.services;

import cl.privera.depin.domain.abstractions.repositories.IProductRepository;
import cl.privera.depin.domain.abstractions.services.IProductService;
import cl.privera.depin.domain.entities.Product;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository repository;

    @Override
    public void add(Product product) {
        log.info("Product service: add");
        repository.save(product);
    }

    @Override
    public void delete(int id) {
        log.info("Product service: delete");
        Optional<Product> product = repository.findById(id);
        product.ifPresent(value -> repository.delete(value));
    }

    @Override
    public Iterable<Product> getAll() {
        log.info("Product service: getAll");
        return repository.findAll();
    }

    @Override
    public Product getSingle(int id) {
        log.info("Product service: getSingle");
        return repository.findById(id).orElse(null);
    }

    @Override
    public void update(Product product) {
        log.info("Product service: update");
        if (!repository.existsById(product.getId())) {
            log.info("Product does not exist");
            return;
        }

        log.info("Saving product");
        repository.save(product);
    }
}
