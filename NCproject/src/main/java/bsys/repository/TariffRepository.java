package bsys.repository;

import bsys.model.Tariff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface TariffRepository extends JpaRepository<Tariff, Integer> {
    Tariff findByIdTariff(int idTariff);

    @Modifying
    @Query("update Tariff t set t.nameTariff = ?1, t.typeTariff = ?2, t.priceTariff = ?3 where t.idTariff = ?4")
    void editTariff(String nameTariff, String typeTariff, double priceTariff, int idTariff);
}
