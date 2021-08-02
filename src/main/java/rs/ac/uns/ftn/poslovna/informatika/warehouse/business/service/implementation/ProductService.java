package rs.ac.uns.ftn.poslovna.informatika.warehouse.business.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.model.Product;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.repository.ProductRepository;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.service.ProductServiceInterface;

import java.util.List;

@Service
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

    public List<Product> findAllPaged(Integer page, Integer size) {
        PageRequest pageReq = PageRequest.of(page, size);
        Page<Product> products = productRepository.findAll(pageReq);

        return products.getContent();
    }

    public Page<Product> findAllPagedp(Integer page, Integer size) {
        PageRequest pageReq = PageRequest.of(page, size);
        Page<Product> products = productRepository.findAll(pageReq);

        return products;
    }

    public List<Product> findAllPagedAndSorted(Integer page, Integer size, String sortDir, String sort) {
        PageRequest pageReq = PageRequest.of(page, size, Sort.Direction.fromString(sortDir), sort);
        Page<Product> products = productRepository.findAll(pageReq);

        return products.getContent();
    }

    public Page<Product> findAllPagedAndSortedp(Integer page, Integer size, String sortDir, String sort) {
        PageRequest pageReq = PageRequest.of(page, size, Sort.Direction.fromString(sortDir), sort);
        Page<Product> products = productRepository.findAll(pageReq);

        return products;
    }

    public List<Product> findByNamePaged(String name, Integer page, Integer size) {
        PageRequest pageReq = PageRequest.of(page, size);
        Page<Product> products = productRepository.findByNameContains(name, pageReq);

        return products.getContent();
    }

    public List<Product> findByNamePagedAndSorted(String name, Integer page, Integer size, String sortDir, String sort) {
        PageRequest pageReq = PageRequest.of(page, size, Sort.Direction.fromString(sortDir), sort);
        Page<Product> products = productRepository.findByNameContains(name, pageReq);

        return products.getContent();
    }
}
