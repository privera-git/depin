package cl.privera.depin.domain.services;

import cl.privera.depin.domain.abstractions.repositories.IProductRepository;
import cl.privera.depin.domain.entities.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ProductServiceTest {

    @MockBean
    private IProductRepository repository;

    @Autowired
    private ProductService sut;

    private Product createTestProduct() {
        var product = new Product();
        product.setId(1);
        product.setDescription("description");
        product.setCategory("category");

        return product;
    }

    private Iterable<Product> createTestProducts() {
        var product1 = new Product();
        product1.setId(1);
        product1.setDescription("description1");
        product1.setCategory("category1");

        var product2 = new Product();
        product2.setId(2);
        product2.setDescription("description2");
        product2.setCategory("category2");

        return Arrays.asList(product1, product2);
    }

    @Test
    public void add_shouldCallRepository() {

        var product = createTestProduct();

        sut.add(product);

        verify(repository, times(1)).save(product);
    }

    @Test
    public void delete_ifIsPresentShouldCallDelete() {
        var product = createTestProduct();
        var findResponse = Optional.of(product);
        when(repository.findById(product.getId())).thenReturn(findResponse);

        sut.delete(product.getId());

        verify(repository, times(1)).delete(product);
    }

    @Test
    public void delete_ifNotIsPresentShouldNotCallDelete() {
        var product = createTestProduct();
        Optional<Product> findResponse = Optional.empty();
        when(repository.findById(product.getId())).thenReturn(findResponse);

        sut.delete(product.getId());

        verify(repository, times(0)).delete(product);
    }

    @Test
    public void getAll_shouldCallRepository() {

        var products = createTestProducts();
        when(repository.findAll()).thenReturn(products);

        var actual = sut.getAll();

        Assertions.assertSame(products, actual);
        verify(repository, times(1)).findAll();
    }

    @Test
    public void getSingle_ifPresentShouldReturnProduct() {

        var product = createTestProduct();
        var findResponse = Optional.of(product);
        when(repository.findById(product.getId())).thenReturn(findResponse);

        var actual = sut.getSingle(product.getId());

        Assertions.assertSame(product, actual);
        verify(repository, times(1)).findById(product.getId());
    }

    @Test
    public void getSingle_ifNotPresentShouldReturnNull() {

        var product = createTestProduct();
        Optional<Product> findResponse = Optional.empty();
        when(repository.findById(product.getId())).thenReturn(findResponse);

        var actual = sut.getSingle(product.getId());

        Assertions.assertNull(actual);
        verify(repository, times(1)).findById(product.getId());
    }

    @Test
    public void update_ifExistsShouldCallSave() {

        var product = createTestProduct();
        var exists = true;
        when(repository.existsById(product.getId())).thenReturn(exists);

        sut.update(product);

        verify(repository, times(1)).save(product);
    }

    @Test
    public void update_ifNotExistsShouldNotCallSave() {

        var product = createTestProduct();
        var exists = false;
        when(repository.existsById(product.getId())).thenReturn(exists);

        sut.update(product);

        verify(repository, times(0)).save(product);
    }
}
