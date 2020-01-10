package app.service;

import app.model.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import app.repos.PurchaseRepository;

import java.util.Date;
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

    public void setPurchaseNumber(int number, int idPurchase) {
        purchaseRepository.setPurchaseNumber(number, idPurchase);
    }

    public void updatePurchaseInfo(Date date, int idStore, int idBuyer, int idBook, int number, double total, int idPurchase) {
        purchaseRepository.updatePurchaseInfo(date, idStore, idBuyer, idBook, number, total, idPurchase);
    }

    public void deletePurchase(int idPurchase) {
        purchaseRepository.deleteById(idPurchase);
    }

    public List<Integer> findDate() {
        return purchaseRepository.findDate();
    }

    public List<Object[]> getBuyerAndStore() {
        return purchaseRepository.getBuyerAndStore();
    }

    public List<Object[]> getPurchaseInfo() {
        return purchaseRepository.getPurchaseInfo();
    }

    public List<Object[]> getInfoByTotal() {
        return purchaseRepository.getInfoByTotal();
    }

    public List<Object[]> getPurchaseInMarch() {
        return purchaseRepository.getPurchaseInMarch();
    }
}
