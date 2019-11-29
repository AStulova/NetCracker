package bsys.service.client;

import bsys.model.Client;
import bsys.service.client.ClientDAO;
import bsys.service.client.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    private ClientDAO clientDAO;

    @Autowired
    public void setClientDAO(ClientDAO clientDAO) {
        this.clientDAO = clientDAO;
    }

    @Transactional
    public List<Client> allClients() {
        return clientDAO.allClients();
    }

    @Transactional
    public void addClient(Client client) {
        clientDAO.addClient(client);
    }

    @Transactional
    public void deleteClient(Client client) {
        clientDAO.deleteClient(client);
    }

    @Transactional
    public void editClient(Client client) {
        clientDAO.editClient(client);
    }

    @Transactional
    public Client getById(int idClient) {
        return clientDAO.getById(idClient);
    }
}