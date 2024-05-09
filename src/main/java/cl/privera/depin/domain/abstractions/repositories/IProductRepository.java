package cl.privera.depin.domain.abstractions.repositories;

import cl.privera.depin.domain.entities.Product;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface IProductRepository extends Repository<Product, Integer> {
    <S extends Product> S save(S entity);

    Optional<Product> findById(Integer primaryKey);

    Iterable<Product> findAll();

    long count();

    void delete(Product entity);

    boolean existsById(Integer primaryKey);
}
