package cl.privera.depin.domain.services;

import cl.privera.depin.domain.abstractions.repositories.IProductRepository;
import cl.privera.depin.domain.abstractions.services.IProductService;
import cl.privera.depin.domain.entities.Product;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository repository;

    @Override
    public void add(Product product) {
        log.info("Product service: add");
        repository.add(product);
    }

    @Override
    public void delete(int id) {
        log.info("Product service: delete");
        repository.delete(id);
    }

    @Override
    public List<Product> getAll() {
        log.info("Product service: getAll");
        return repository.getAll();
    }

    @Override
    public Product getSingle(int id) {
        log.info("Product service: getSingle");
        return repository.getSingle(id);
    }

    @Override
    public void update(Product product) {
        log.info("Product service: update");
        var dbProduct = repository.getSingle(product.getId());
        if (dbProduct != null) {
            repository.update(product);
        }
    }
}
