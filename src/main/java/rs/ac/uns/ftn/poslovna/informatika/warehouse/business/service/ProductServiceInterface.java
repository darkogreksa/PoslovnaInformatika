package rs.ac.uns.ftn.poslovna.informatika.warehouse.business.service;

import org.springframework.data.domain.Page;
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

    List<Product> findAllPaged(Integer page, Integer size);

    Page<Product> findAllPagedp(Integer page, Integer size);

    List<Product> findAllPagedAndSorted(Integer page, Integer size, String sortDir, String sort);

    Page<Product> findAllPagedAndSortedp(Integer page, Integer size, String sortDir, String sort);

    List<Product> findByNamePaged(String name, Integer page, Integer size);

    List<Product> findByNamePagedAndSorted(String name, Integer page, Integer size, String sortDir, String sort);

}
