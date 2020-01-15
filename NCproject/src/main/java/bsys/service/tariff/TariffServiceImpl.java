package bsys.service.tariff;

import bsys.model.Tariff;
import bsys.repository.TariffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TariffServiceImpl implements TariffService {
    private TariffRepository tariffRepository;

    @Autowired
    public void setTariffRepository(TariffRepository tariffRepository) {
        this.tariffRepository = tariffRepository;
    }

    @Override
    public List<Tariff> allTariffs() {
        return tariffRepository.findAll();
    }

    @Override
    public void addTariff(Tariff tariff) {
        tariffRepository.save(tariff);
    }

    @Override
    @Transactional
    public void deleteTariff(Tariff tariff) {
        tariffRepository.delete(tariff);
    }

    @Override
    public Tariff getById(int idTariff) {
        return tariffRepository.findByIdTariff(idTariff);
    }
}
