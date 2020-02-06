package bsys.service.bill;

import bsys.model.Bill;
import bsys.repository.BillRepository;
import bsys.service.client.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BillServiceImpl implements BillService {
    private ClientService clientService;
    private BillRepository billRepository;

    @Autowired
    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }

    @Autowired
    public void setBillRepository(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    @Override
    public List<Bill> allBills(int idClient) {
        return billRepository.generateBills(idClient);
        //return billRepository.findAllByClient(clientService.getById(idClient));
    }

/*
    @Override
    @Transactional
    public int generateBill(int idClient) {
        return billRepository.generateBills(idClient);
    }
*/

    @Override
    @Transactional
    public void editBill(Bill bill) {
        billRepository.editDiscount(bill.getDiscount(), bill.getIdBill());
        //billRepository.save(bill);
    }

    @Override
    public Bill getById(int idBill) {
        return billRepository.getOne(idBill);
    }
}