package tp06.dao;

import tp06.entities.Product;

import java.util.List;

public interface ProductDAO extends DAO<Product,Long>{
    List<Product> searchProductByQuery(String query);
}
