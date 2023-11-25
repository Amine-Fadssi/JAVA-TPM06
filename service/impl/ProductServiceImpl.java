package tp06.service.impl;

import tp06.dao.ProductDAO;
import tp06.entities.Product;
import tp06.service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    ProductDAO productDAO;

    public ProductServiceImpl(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Override
    public void addProduct(Product product) {
        productDAO.save(product);
    }

    @Override
    public void deleteProductBy(long id) {
        productDAO.removeById(id);
    }
    @Override
    public List<Product> getAllProducts() {
        return productDAO.getAll();
    }

    @Override
    public void updateProduct(Product product) {
        productDAO.update(product);
    }

    @Override
    public List<Product> searchProductByQuery(String query) {
        return productDAO.searchProductByQuery(query);
    }

}
