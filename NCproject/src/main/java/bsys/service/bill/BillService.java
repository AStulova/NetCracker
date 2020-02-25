package bsys.service.bill;

import bsys.model.Bill;

import java.util.List;

public interface BillService {
    List<Bill> allBills(int idClient);
    Bill getById(int idBill);
}
