package cl.privera.depin.application.mappers;

import cl.privera.depin.application.dtos.AddProductDto;
import cl.privera.depin.application.dtos.ProductDto;
import cl.privera.depin.domain.entities.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class ProductMapper implements cl.privera.depin.application.abstractions.mappers.IProductMapper {

    @Override
    public ProductDto map(Product entity) {
        if (entity == null) {
            return null;
        }

        return new ProductDto(
                entity.getId(),
                entity.getDescription(),
                entity.getCategory());
    }

    @Override
    public Iterable<ProductDto> map(Iterable<Product> entities) {
        if (entities == null) {
            return null;
        }

        var dtos = new ArrayList<ProductDto>();
        entities.forEach(e -> dtos.add(new ProductDto(e.getId(), e.getDescription(), e.getCategory())));
        return dtos;
    }

    @Override
    public Product map(AddProductDto dto) {
        if (dto == null) {
            return null;
        }

        var entity = new Product();
        entity.setDescription(dto.description());
        entity.setCategory(dto.category());
        return entity;
    }

    @Override
    public Product map(ProductDto dto) {
        if (dto == null) {
            return null;
        }

        var entity = new Product();
        entity.setId(dto.id());
        entity.setDescription(dto.description());
        entity.setCategory(dto.category());
        return entity;
    }
}
