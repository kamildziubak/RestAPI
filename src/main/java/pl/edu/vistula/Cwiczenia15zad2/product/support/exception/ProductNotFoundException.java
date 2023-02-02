package pl.edu.vistula.Cwiczenia15zad2.product.support.exception;

public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(Long id){
        super(String.format("Product with id "  + id + " not found"));
    }
}
