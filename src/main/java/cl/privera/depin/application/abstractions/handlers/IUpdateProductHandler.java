package cl.privera.depin.application.abstractions.handlers;

import cl.privera.depin.application.dtos.ProductDto;

public interface IUpdateProductHandler {
    ProductDto handle(ProductDto product);
}
