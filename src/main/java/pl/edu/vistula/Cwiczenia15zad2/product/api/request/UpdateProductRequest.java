package pl.edu.vistula.Cwiczenia15zad2.product.api.request;

public class UpdateProductRequest extends ProductRequest{
    private final Long id;

    public UpdateProductRequest(String name, Long id){
        super (name);
        this.id=id;
    }

    public Long getId() {
        return id;
    }
}
