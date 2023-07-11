package com.roger.domain.product;

import lombok.*;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.*;
import java.util.UUID;

@Table(name = "product")
@Entity(name = "product")
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    private Integer price;

    public Product(@RequestBody RequestProduct requestProduct) {
        this.name = requestProduct.getName();
        this.price = requestProduct.getPrice();
    }


}


