package bsys.repository;

import bsys.model.Tariff;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TariffRepository extends JpaRepository<Tariff, Integer> {
    Tariff findByIdTariff(int idTariff);
}
