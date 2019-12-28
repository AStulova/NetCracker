package bsys.service.bill;

import bsys.model.Bill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class BillServiceImpl implements BillService {
    private BillDAO billDAO;

    @Autowired
    public void setBillDAO(BillDAO billDAO) {
        this.billDAO = billDAO;
    }

    @Transactional
    public List<Bill> allBills() {
        return billDAO.allBills();
    }

    @Transactional
    public void addBill(Bill bill) {
        billDAO.addBill(bill);
    }

    @Transactional
    public void deleteBill(Bill bill) {
        billDAO.deleteBill(bill);
    }

    @Transactional
    public void editBill(Bill bill) {
        billDAO.editBill(bill);
    }

    @Transactional
    public Bill getById(int idBill) {
        return billDAO.getById(idBill);
    }
}