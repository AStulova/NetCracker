package bsys.service.bill;

import bsys.model.Bill;
import bsys.model.Client;

import java.util.List;

public interface BillService {
    List<Bill> getBills(Client client);
    Bill getById(int idBill);
    void updateBill(int idClient);
}
