package rs.ac.uns.ftn.poslovna.informatika.warehouse.business.service;

import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.model.Product;

import java.util.List;

public interface ProductServiceInterface {

    Long count();

    Product findOne(Integer id);

    Product create(Product product);

    Product update (Product product);

    void remove (Product product);

    void removeById(Integer id);

    List<Product> findAll();

    List<Product> findByName(String name);

}
