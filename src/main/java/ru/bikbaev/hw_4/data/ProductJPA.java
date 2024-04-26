package ru.bikbaev.hw_4.data;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bikbaev.hw_4.model.Product;

public interface ProductJPA extends JpaRepository<Product,Integer> {

}
