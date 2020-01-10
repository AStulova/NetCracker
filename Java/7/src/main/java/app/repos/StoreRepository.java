package app.repos;

import app.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StoreRepository extends JpaRepository<Store, Integer> {
    Store findByIdStore(int idStore);

    @Modifying
    @Query("update Store s set s.placement = ?1 where s.idStore = ?2")
    void setStorePlacement(String placement, int idStore);

    @Modifying
    @Query("update Store s set s.name = ?1, s.placement = ?2, s.commission = ?3 where s.idStore = ?4")
    void updateStoreInfo(String name, String placement, double commission, int idStore);

    @Query("select s.name from Store s where s.placement = ?1 or s.placement = ?2")
    List<String> findByPlacement(String placement1, String placement2);

    @Query("select s.name " +
            "from Purchase p inner join Buyer b on p.idBuyer = b.idBuyer inner join Store s on p.idStore = s.idStore" +
            " where s.placement Not like 'Автозаводский' and b.discount between 10 and 15")
    List<String> getStores();
}
