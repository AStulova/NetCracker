package service;

import model.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseService {
    @Autowired
    private PurchaseRepository purchaseRepository;

    public List<Purchase> findAllPurchases() {
        return purchaseRepository.findAll();
    }

    public Purchase findPurchase(int idPurchase) {
        return purchaseRepository.findByIdPurchase(idPurchase);
    }

    public void addPurchase(Purchase purchase) {
        purchaseRepository.save(purchase);
    }

    public void setPurchaseNumber(String number, int idPurchase) {
        purchaseRepository.setPurchaseNumber(number, idPurchase);
    }

    public void updatePurchaseInfo(String date, int idStore, int idBuyer, int idBook, int number, double total, int idPurchase) {
        purchaseRepository.updatePurchaseInfo(date, idStore, idBuyer, idBook, number, total, idPurchase);
    }

    public void deletePurchase(int idPurchase) {
        purchaseRepository.deleteById(idPurchase);
    }
}
