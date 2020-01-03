package service;

import model.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface PurchaseRepository extends JpaRepository<Purchase, Integer> {
    Purchase findByIdPurchase(int idPurchase);

    @Modifying
    @Query("update Purchase p set p.number = ?1 where p.idPurchase = ?2")
    void setPurchaseNumber(String number, int idPurchase);

    @Modifying
    @Query("update Purchase p set p.date = ?1, p.idStore = ?2, p.idBuyer = ?3, p.idBook = ?4," +
            "p.number = ?5, p.total = ?6 where p.idPurchase = ?7")
    void updatePurchaseInfo(String date, int idStore, int idBuyer, int idBook, int number, double total, int idPurchase);
}
