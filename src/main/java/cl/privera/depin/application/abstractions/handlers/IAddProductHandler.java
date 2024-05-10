package cl.privera.depin.application.abstractions.handlers;

import cl.privera.depin.application.dtos.AddProductDto;
import cl.privera.depin.application.dtos.ProductDto;

public interface IAddProductHandler {
    ProductDto handle(AddProductDto product);
}
