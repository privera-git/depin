package cl.privera.depin.application.abstractions.mappers;

import cl.privera.depin.application.dtos.AddProductDto;
import cl.privera.depin.application.dtos.ProductDto;
import cl.privera.depin.domain.entities.Product;

public interface IProductMapper {
    ProductDto map(Product entity);
    Iterable<ProductDto> map(Iterable<Product> entities);
    Product map(AddProductDto dto);
    Product map(ProductDto dto);
}
