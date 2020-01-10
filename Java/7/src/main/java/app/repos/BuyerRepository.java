package app.repos;

import app.model.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BuyerRepository extends JpaRepository<Buyer, Integer> {
    Buyer findByIdBuyer(int idBuyer);

    @Modifying
    @Query("update Buyer b set b.residence = ?1 where b.idBuyer = ?2")
    void setBuyerResidence(String residence, int idBuyer);

    @Modifying
    @Query("update Buyer b set b.surname= ?1, b.residence = ?2, b.discount = ?3 where b.idBuyer = ?4")
    void updateBuyerInfo(String surname, String residence, int discount, int idBuyer);

    @Query("select distinct b.residence from  Buyer b")
    List<String> findResidence();

    @Query("select b.surname, b.discount from Buyer b where b.residence = ?1")
    List<Buyer>findSurnameAndDiscount(String residence);
}
