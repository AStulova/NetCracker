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
    private ClientService clientService;

    @Autowired
    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }

    @Autowired
    public void setBillDAO(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    public List<Object> allBills() {
        Client client = clientService.getAuthClient();
        return billRepository.generateBills(client.getIdClient());
        //return billRepository.findAllByClient(client);
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