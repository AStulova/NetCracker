package app.repos;

import app.model.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface PurchaseRepository extends JpaRepository<Purchase, Integer> {
    Purchase findByIdPurchase(int idPurchase);

    @Modifying
    @Query("update Purchase p set p.number = ?1 where p.idPurchase = ?2")
    void setPurchaseNumber(int number, int idPurchase);

    @Modifying
    @Query("update Purchase p set p.date = ?1, p.idStore = ?2, p.idBuyer = ?3, p.idBook = ?4," +
            "p.number = ?5, p.total = ?6 where p.idPurchase = ?7")
    void updatePurchaseInfo(Date date, int idStore, int idBuyer, int idBook, int number, double total, int idPurchase);

    @Query(value = "select distinct extract(MONTH from p.date) from Purchase p", nativeQuery = true)
    List<Integer> findDate();

    @Query("select b.surname, s.name " +
            "from Purchase p inner join Buyer b on p.idBuyer = b.idBuyer inner join Store s on p.idStore = s.idStore group by s.name")
    List<Object[]> getBuyerAndStore();

    @Query("select p.date, br.surname, br.discount, bk.name, p.number " +
            "from Purchase p inner join Buyer br on p.idBuyer = br.idBuyer inner join Book bk on p.idBook = bk.idBook")
    List<Object[]> getPurchaseInfo();

    @Query("select p.idPurchase, b.surname, p.date " +
            "from Purchase p inner join Buyer b on p.idBuyer = b.idBuyer " +
            "where p.total >= 60000")
    List<Object[]> getInfoByTotal();

    @Query(value = "select b.surname, b.residence, p.date" +
            " from Purchase p inner join Buyer b on p.idBuyer = b.idBuyer " +
            "where extract (MONTH from p.date) > 3 " +
            "order by p.date", nativeQuery = true)
    List<Object[]> getPurchaseInMarch();

}
