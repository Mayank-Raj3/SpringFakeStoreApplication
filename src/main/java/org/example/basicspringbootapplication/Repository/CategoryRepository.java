package org.example.basicspringbootapplication.Repository;

import org.example.basicspringbootapplication.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
