package pl.edu.vistula.Cwiczenia15zad2.product.support;

import org.springframework.stereotype.Component;
import pl.edu.vistula.Cwiczenia15zad2.product.api.request.ProductRequest;
import pl.edu.vistula.Cwiczenia15zad2.product.api.request.UpdateProductRequest;
import pl.edu.vistula.Cwiczenia15zad2.product.api.response.ProductResponse;
import pl.edu.vistula.Cwiczenia15zad2.product.domain.Product;

@Component
public class ProductMapper {
    public Product toProduct(ProductRequest productRequest){
        return new Product(productRequest.getName());
    }

    public Product toProduct(Product product, UpdateProductRequest updateProductRequest){
        product.setName(updateProductRequest.getName());
        return product;
    }

    public static ProductResponse toProductResponse(Product product){
        return new ProductResponse(product.getId(),product.getName());
    }
}
