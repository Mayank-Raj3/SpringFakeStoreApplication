package org.example.basicspringbootapplication.Repository;

import org.example.basicspringbootapplication.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    //http://localhost:3001/api/categories?minPrice=2500
    @Query("SELECT p from Product p WHERE p.price > :minPrice")
    List<Product> findExpensiveProducts(@Param("minPrice") double minPrice);

    @Query(value="Select * FROM product WHERE MATCH(name, description) AGAINST (:keyword)", nativeQuery = true)
    List<Product> searchFullText(@Param("keyword") String keyword);


    //:minPrice < "minPrice" in @Param("minPrice")
    //:brand < "brand" in @Param("brand")
    @Query("Select p from Product p WHERE p.price > :minPrice AND p.brand = :brand")
    List<Product> findByBrandAndPrice(
            @Param("minPrice") int price,
            @Param("brand") String brandName
    );
}
