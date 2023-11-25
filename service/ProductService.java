package tp06.service;


import tp06.entities.Product;

import java.util.List;

public interface ProductService {
    public void addProduct(Product products);
    public void deleteProductBy(long id);
    public List<Product> getAllProducts();
    public void updateProduct(Product product);
    public List<Product> searchProductByQuery(String query);
}
