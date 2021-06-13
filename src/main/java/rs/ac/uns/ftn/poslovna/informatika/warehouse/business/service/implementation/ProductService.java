package rs.ac.uns.ftn.poslovna.informatika.warehouse.business.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.model.Product;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.repository.ProductRepository;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.service.ProductServiceInterface;

import java.util.List;

public class ProductService implements ProductServiceInterface {

    @Autowired
    ProductRepository productRepository;

    public Long count() {
        return productRepository.count();
    }

    public Product findOne(Integer id) {
        return productRepository.getOne(id);
    }

    public Product create(Product product) {
        return productRepository.save(product);
    }

    public Product update(Product product) {
        return productRepository.save(product);
    }

    public void remove(Product product) {
        productRepository.delete(product);
    }

    public void removeById(Integer id) {
        productRepository.deleteById(id);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public List<Product> findByName(String name) {
        return productRepository.findByNameContains(name);
    }
}
