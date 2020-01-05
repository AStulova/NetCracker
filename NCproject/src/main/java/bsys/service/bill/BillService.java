package bsys.service.bill;

import bsys.model.Bill;

import java.util.List;

public interface BillService {
    List<Bill> allBills(int idClient);
    void addBill(Bill bill);
    void deleteBill(Bill bill);
    Bill getById(int idBill);
}
