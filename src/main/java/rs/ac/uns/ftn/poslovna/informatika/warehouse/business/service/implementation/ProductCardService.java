package rs.ac.uns.ftn.poslovna.informatika.warehouse.business.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.model.ProductCard;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.model.TrafficDirection;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.model.TrafficType;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.model.WarehouseCardAnalytics;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.repository.ProductCardRepository;
import rs.ac.uns.ftn.poslovna.informatika.warehouse.business.service.ProductCardServiceInterface;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductCardService implements ProductCardServiceInterface {

    @Autowired
    ProductCardRepository productCardRepository;

    @Autowired
    AnalyticsService analyticsService;

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

    @Transactional
    @Override
    public boolean nivelacija(Integer id){
//        RobnaKartica rk = robnaKarticaRepository.findById(id).get();
        ProductCard pk = productCardRepository.findById(id).get();
//        List<AnalitikaMagacinskeKartice> amks = amkService.findAllForRobnaKarticaByRKId(id);
        List<WarehouseCardAnalytics> wca = analyticsService.findAllForProductCardByProductCardId(id);
        int ukVr = 0;
        for (WarehouseCardAnalytics a: wca) {
            if (a.getTrafficType()== TrafficType.NI) {
                continue;
            }
            if (a.getTrafficType() == TrafficType.PR) {
                ukVr += a.getValue().intValue();
            }
            if (a.getTrafficType() == TrafficType.OT) {
                ukVr -= a.getValue().intValue();
            }
        }
        if (ukVr == 0) {
            return false;
        }
        if (ukVr == pk.getTotalValue()) {
            return false;

        }
//        AnalitikaMagacinskeKartice amkNivelacija = new AnalitikaMagacinskeKartice();
        WarehouseCardAnalytics wcaNA = new WarehouseCardAnalytics();
        wcaNA.setTrafficType(TrafficType.NI);
        wcaNA.setValue(new BigDecimal(pk.getTotalValue() - ukVr));
        wcaNA.setProductCard(pk);
        wcaNA.setPrice(new BigDecimal(0));
        wcaNA.setQuantity(0);
        wcaNA.setTrafficDirection(TrafficDirection.IN);
        wcaNA = analyticsService.create(wcaNA);
        wcaNA.setOrdinalNumber(wcaNA.getId());
        analyticsService.update(wcaNA);
        pk.setTotalValue(ukVr);
        productCardRepository.save(pk);
        return true;
    }

}
