package cl.privera.depin.domain.abstractions.services;

import cl.privera.depin.domain.entities.Product;

import java.util.List;

public interface IProductService {
    void add(Product product);
    void delete(int id);
    List<Product> getAll();
    Product getSingle(int id);
    void update(Product product);
}
