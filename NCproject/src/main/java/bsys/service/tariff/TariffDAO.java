package bsys.service.tariff;

import bsys.model.Tariff;

import java.util.List;

public interface TariffDAO {
    List<Tariff> allTariffs();
    void addTariff(Tariff tariff);
    void deleteTariff(Tariff tariff);
    Tariff getById(int idTariff);
}
