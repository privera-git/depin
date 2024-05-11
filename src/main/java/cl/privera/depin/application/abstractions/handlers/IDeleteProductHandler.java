package cl.privera.depin.application.abstractions.handlers;

import cl.privera.depin.application.dtos.ProductDto;

public interface IDeleteProductHandler {
    boolean handle(int id);
}
