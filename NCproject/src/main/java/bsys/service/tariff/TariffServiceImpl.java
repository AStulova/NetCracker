package bsys.service.tariff;

import bsys.model.Tariff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TariffServiceImpl implements TariffService {
    private TariffDAO tariffDAO;

    @Autowired
    public void setTariffDAO(TariffDAO tariffDAO) {
        this.tariffDAO = tariffDAO;
    }

    @Transactional
    public List<Tariff> allTariffs() {
        return tariffDAO.allTariffs();
    }

    @Transactional
    public void addTariff(Tariff tariff) {
        tariffDAO.addTariff(tariff);
    }

    @Transactional
    public void deleteTariff(Tariff tariff) {
        tariffDAO.deleteTariff(tariff);
    }

    @Transactional
    public Tariff getById(int idTariff) {
        return tariffDAO.getById(idTariff);
    }
}
