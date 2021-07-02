package rs.ac.uns.ftn.poslovna.informatika.warehouse.business.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.model.ProductCard;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.repository.ProductCardRepository;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.service.ProductCardServiceInterface;

import java.util.List;

@Service
public class ProductCardService implements ProductCardServiceInterface {

    @Autowired
    ProductCardRepository productCardRepository;

    @Override
    public ProductCard findOne(Integer id) {
        return productCardRepository.findById(id).get();
    }

    @Override
    public List<ProductCard> findAll() {
        return productCardRepository.findAll();
    }

    @Override
    public ProductCard save(ProductCard productCard) {
        return productCardRepository.save(productCard);
    }

    @Override
    public void delete(Integer id) {
        productCardRepository.deleteById(id);
    }

    @Override
    public Page<ProductCard> findAllPaged(Integer page, Integer size){
        PageRequest pageReq = PageRequest.of(page, size);
        Page<ProductCard> productCards = productCardRepository.findAll(pageReq);

        return productCards;
    }

    @Override
    public List<ProductCard> findAllByOrderByBusinessYearDesc() {
        return productCardRepository.findAllByOrderByBusinessYearDesc();
    }

    @Override
    public List<ProductCard> findByWarehouse_Id(Integer id) {
        return productCardRepository.findByWarehouse_Id(id);
    }

    @Override
    public List<ProductCard> findByBusinessYear_Id(Integer id) {
        return productCardRepository.findByBusinessYear_Id(id);
    }
}
