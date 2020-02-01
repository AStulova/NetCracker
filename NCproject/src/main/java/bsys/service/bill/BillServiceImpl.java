package bsys.service.bill;

import bsys.model.Bill;
import bsys.model.Client;
import bsys.repository.BillRepository;
import bsys.service.client.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BillServiceImpl implements BillService {
    private BillRepository billRepository;

    @Autowired
    public void setBillRepository(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    @Override
    @Transactional
    public List<Object> allBills(int idClient) {
        return billRepository.generateBills(idClient);
    }

    @Override
    public void addBill(Bill bill) {
        billRepository.save(bill);
    }

    @Override
    public void deleteBill(Bill bill) {
        billRepository.delete(bill);
    }

    @Override
    public Bill getById(int idBill) {
        return billRepository.getOne(idBill);
    }
}