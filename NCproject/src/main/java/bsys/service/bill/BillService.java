package bsys.service.bill;

import bsys.model.Bill;

import java.util.List;

public interface BillService {
    List<Bill> allBills(int idClient);
    //int generateBill(int idClient);
    void editBill(Bill bill);
    Bill getById(int idBill);
}
