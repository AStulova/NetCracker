package bsys.service.tariff;

import bsys.model.Tariff;

import java.util.List;

public interface TariffService {
    List<Tariff> getTariffs();
    void addTariff(Tariff tariff);
    Tariff getById(int idTariff);
}
