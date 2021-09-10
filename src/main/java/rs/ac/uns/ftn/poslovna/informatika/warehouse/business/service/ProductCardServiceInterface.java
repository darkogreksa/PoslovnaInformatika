package rs.ac.uns.ftn.poslovna.informatika.warehouse.business.service;

import org.springframework.data.domain.Page;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.model.ProductCard;

import java.util.List;

public interface ProductCardServiceInterface {

    ProductCard findOne(Integer id);

    List<ProductCard> findAll();

    ProductCard save(ProductCard productCard);

    void delete(Integer id);

    Page<ProductCard> findAllPaged(Integer page, Integer size);

    List<ProductCard> findAllByOrderByBusinessYearDesc();

    List<ProductCard> findByWarehouse_Id(Integer id);

    List<ProductCard> findByBusinessYear_Id(Integer id);

    boolean nivelacija(Integer id);
}
