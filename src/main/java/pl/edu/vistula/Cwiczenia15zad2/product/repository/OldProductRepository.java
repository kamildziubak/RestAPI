package pl.edu.vistula.Cwiczenia15zad2.product.repository;

import org.springframework.stereotype.Repository;
import pl.edu.vistula.Cwiczenia15zad2.product.domain.Product;

import java.util.*;

@Repository
public class OldProductRepository {
    protected final Map<Long, Product> map = new HashMap<>();
    protected long counter = 1;

    public Product save(Product entity){
        setId(entity);
        return entity;
    }

    private Product setId(Product entity){
        if(entity.getId()!=null){
            map.put(entity.getId(), entity);
        }
        else{
            entity.setId(counter);
            map.put(counter,entity);
            counter++;
        }
        return entity;
    }

    public Optional<Product> findById(Long id) {
        return Optional.ofNullable(map.get(id));
    }

    public List<Product> findAll() {
        return new ArrayList<>(map.values());
    }

    public Optional<Product> deleteById(Long id) {
        Product deletedProduct = map.get(id);
        map.remove(id);
        return Optional.ofNullable(deletedProduct);
    }
}