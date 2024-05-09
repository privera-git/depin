package cl.privera.depin.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Getter @Setter private int id;
    @Getter @Setter private String description;
    @Getter @Setter private String category;
}
