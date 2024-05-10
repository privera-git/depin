package cl.privera.depin.application.abstractions.handlers;

import cl.privera.depin.application.dtos.ProductDto;

public interface IGetProductHandler {
    ProductDto handle(int id);
}
