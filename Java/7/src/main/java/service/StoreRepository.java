package service;

import model.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface StoreRepository extends JpaRepository<Store, Integer> {
    Store findByIdStore(int idStore);

    @Modifying
    @Query("update Store s set s.placement = ?1 where s.idStore = ?2")
    void setStorePlacement(String placement, int idStore);

    @Modifying
    @Query("update Store s set s.name = ?1, s.placement = ?2, s.commission = ?3 where s.idStore = ?4")
    void updateStoreInfo(String name, String placement, double commission, int idStore);
}
