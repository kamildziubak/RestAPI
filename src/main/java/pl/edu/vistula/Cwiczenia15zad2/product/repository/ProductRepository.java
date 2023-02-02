package pl.edu.vistula.Cwiczenia15zad2.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.vistula.Cwiczenia15zad2.product.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}