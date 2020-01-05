package bsys.service.bill;

import bsys.model.Bill;
import bsys.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class BillServiceImpl implements BillService {
    private BillRepository billRepository;

    @Autowired
    public void setBillDAO(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    public List<Bill> allBills(int idClient) {
        return billRepository.findAllByIdClient(idClient);
    }

    public void addBill(Bill bill) {
        billRepository.save(bill);
    }

    public void deleteBill(Bill bill) {
        billRepository.delete(bill);
    }

    public Bill getById(int idBill) {
        return billRepository.getOne(idBill);
    }
}