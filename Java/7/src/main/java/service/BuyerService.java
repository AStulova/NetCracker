package service;

import model.Buyer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuyerService {
    @Autowired
    private BuyerRepository buyerRepository;

    public List<Buyer> findAllBuyers() {
        return buyerRepository.findAll();
    }

    public Buyer findBuyer(int idBuyer) {
        return buyerRepository.findByIdBuyer(idBuyer);
    }

    public void addBuyer(Buyer buyer) {
        buyerRepository.save(buyer);
    }

    public void setBuyerResidence(String residence, int idBuyer) {
        buyerRepository.setBuyerResidence(residence, idBuyer);
    }

    public void updateBuyerInfo(String surname, String residence, int discount, int idBuyer) {
        buyerRepository.updateBuyerInfo(surname, residence, discount, idBuyer);
    }

    public void deleteBuyer(int idBuyer) {
        buyerRepository.deleteById(idBuyer);
    }
}
