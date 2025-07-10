package org.example.basicspringbootapplication.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Category extends BaseEntity{
        @Column(nullable = false, unique = true)
        private String name;

        //This does not mean that you're trying to store a list of products inside category table
        //Telling JPA , the relationship is already owned by the product entity. So, just read from there.
        @OneToMany(mappedBy = "category")
        private List<Product> products;

}
