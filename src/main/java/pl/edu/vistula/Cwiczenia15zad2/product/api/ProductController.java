package pl.edu.vistula.Cwiczenia15zad2.product.api;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.vistula.Cwiczenia15zad2.product.api.request.ProductRequest;
import pl.edu.vistula.Cwiczenia15zad2.product.api.request.UpdateProductRequest;
import pl.edu.vistula.Cwiczenia15zad2.product.api.response.ProductResponse;
import pl.edu.vistula.Cwiczenia15zad2.product.service.ProductService;
import pl.edu.vistula.Cwiczenia15zad2.product.support.exception.ProductNotFoundException;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    @Operation(summary="Create new object")
    public ResponseEntity<ProductResponse> create(@RequestBody ProductRequest productRequest){
        ProductResponse productResponse = productService.create(productRequest);
        return new ResponseEntity<>(productResponse, HttpStatus.CREATED);
    }

    @GetMapping ("/{id}")
    @Operation(summary="Find product by id")
    public ResponseEntity<ProductResponse> find (@PathVariable Long id){
        try {
            ProductResponse productResponse = productService.find(id);
            return ResponseEntity.status(HttpStatus.OK).body(productResponse);
        }
        catch (ProductNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping
    @Operation(summary="Find all products")
    public ResponseEntity<List<ProductResponse>> findAll (){
        List<ProductResponse> productResponses = productService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(productResponses);
    }

    @PutMapping("/{id}")
    @Operation(summary="Update product by id")
    public ResponseEntity<ProductResponse> update (@PathVariable Long id, @RequestBody UpdateProductRequest updateProductRequest)
    {
        ProductResponse productResponse = productService.update(id, updateProductRequest);
        return ResponseEntity.status(HttpStatus.OK).body(productResponse);
    }

    @DeleteMapping("/{id}")
    @Operation(summary="Delete product by id")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        productService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}