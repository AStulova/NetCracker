package bsys.service.bill;

import bsys.model.Bill;
import bsys.model.Client;
import bsys.repository.BillRepository;
import bsys.service.client.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillServiceImpl implements BillService {
    private BillRepository billRepository;

    @Autowired
    public void setBillRepository(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    @Override
    public List<Bill> getBills(Client client) {
        return billRepository.findAllByClientOrderByDateBillDesc(client);
    }

    @Override
    public void updateBill(int idClient) {
        billRepository.updateBill(idClient);
    }

    @Override
    public Bill getById(int idBill) {
        return billRepository.getOne(idBill);
    }
}